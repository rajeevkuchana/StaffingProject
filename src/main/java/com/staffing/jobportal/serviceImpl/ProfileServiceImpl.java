package com.staffing.jobportal.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.bson.json.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.staffing.jobportal.models.JobDescription;
import com.staffing.jobportal.models.JobProfiles;
import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.models.SearchJob;
import com.staffing.jobportal.models.User;
import com.staffing.jobportal.repo.JobDescriptionRepo;
import com.staffing.jobportal.repo.JobProfileRepo;
import com.staffing.jobportal.repo.ProfileDetailsRepo;
import com.staffing.jobportal.repo.UserRepo;
import com.staffing.jobportal.service.ProfileService;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.model.S3Object;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private UserRepo userRepository;
	// private List<ProfileDetails> profiles = new ArrayList<>();
	@Autowired
	private ProfileDetailsRepo profileDetailsRepo;

	@Autowired
	private JobDescriptionRepo jobDescriptionRepo;

	@Autowired
	private JobProfileRepo jobProfileRepo;

	@Autowired
	private S3Client s3Client;

	@Value("${aws.s3.bucket}")
	private String bucketName;

	@Value("${aws.region}")
	private String region;

	// @Value("${aws.accessKeyId}")
	// private String accessKeyId;

	// @Value("${aws.secretAccessKey}")
	// private String secretAccessKey;

	@Override
	public List<ProfileSummary> getAllProfiles(SearchJob searchJob) {

		List<ProfileSummary> profileSummaryList = new ArrayList<>();

		List<ProfileDetails> profiles = null;
		String email = searchJob.getEmail();
		User user = null;
		String company = null;
		int startExp = 0;
		int endExp = 0;
		int budget = 0;
		try {
			user = userRepository.findByEmail(email);
			if (null != searchJob && null != searchJob.getExperienceRange()) {
				if (searchJob.getExperienceRange().equalsIgnoreCase("exRange00")
						|| searchJob.getExperienceRange().equalsIgnoreCase("")) {
					startExp = 0;
					endExp = 50;
				} else if (searchJob.getExperienceRange().equalsIgnoreCase("exRange01")) {
					startExp = 0;
					endExp = 5;
				} else if (searchJob.getExperienceRange().equalsIgnoreCase("exRange02")) {
					startExp = 5;
					endExp = 10;
				} else if (searchJob.getExperienceRange().equalsIgnoreCase("exRange03")) {
					startExp = 10;
					endExp = 50;
				}
			}
			if (searchJob.getBudget() == 0) {
				budget = 200;
			} else {
				budget = searchJob.getBudget();
			}

			List<String> jobProfileUpper = searchJob.getJobProfile();
			if (null != jobProfileUpper) {
				jobProfileUpper.replaceAll(String::toUpperCase);
			}

			if (null != user && null != user.getRole() && user.getRole().equalsIgnoreCase("Client")) {
				company = user.getCompany();
				if (null != jobProfileUpper && jobProfileUpper.size() > 0 && searchJob.getNoticePeriod() == 0) {
					profiles = profileDetailsRepo.findAllByfilterCriteria(searchJob.getJobCategory(), jobProfileUpper,
							company, startExp, endExp, budget);

				} else if (null != jobProfileUpper && jobProfileUpper.size() > 0
						&& !(searchJob.getNoticePeriod() == 0)) {
					profiles = profileDetailsRepo.findAllByfilterCriteria(searchJob.getJobCategory(), jobProfileUpper,
							company, startExp, endExp, searchJob.getNoticePeriod(), budget);

				} else if (null != jobProfileUpper && !(jobProfileUpper.size() > 0)
						&& (searchJob.getNoticePeriod() == 0)) {
					profiles = profileDetailsRepo.findAllByJobCat(searchJob.getJobCategory(), company, startExp, endExp,
							budget);
				} else if (null != jobProfileUpper && !(jobProfileUpper.size() > 0)
						&& !(searchJob.getNoticePeriod() == 0)) {
					profiles = profileDetailsRepo.findAllByJobCat(searchJob.getJobCategory(), company, startExp, endExp,
							searchJob.getNoticePeriod(), budget);
				}
				Iterator<ProfileDetails> itr1 = profiles.iterator();
				while (itr1.hasNext()) {
					ProfileDetails profileDetails = itr1.next();
					ProfileSummary profilSummary = new ProfileSummary();
					profilSummary.setProfileId(profileDetails.getProfileId());
					profilSummary.setFirstName(profileDetails.getFirstName());
					profilSummary.setLastName(profileDetails.getLastName());
					profilSummary.setCurrentCompany(profileDetails.getCurrentCompany());
					profilSummary.setDesignation(profileDetails.getDesignation());
					profilSummary.setLocation(profileDetails.getLocation());
					profilSummary.setCurrentCTC(profileDetails.getCurrentCTC());
					profilSummary.setExpectedCTC(profileDetails.getExpectedCTC());
					profilSummary.setOverallExp(profileDetails.getOverallExp());
					profilSummary.setRelevantExp(profileDetails.getRelevantExp());
					profilSummary.setOverAllRating(profileDetails.getOverAllRating());
					profilSummary.setMatchPer(profileDetails.getMatchPer());

					profileSummaryList.add(profilSummary);
				}
			} else if (null != user && null != user.getRole() && (user.getRole().equalsIgnoreCase("Recruiter"))) {

				// ---------------------------------------

				if (null != jobProfileUpper && jobProfileUpper.size() > 0 && searchJob.getNoticePeriod() == 0) {
					if (null == searchJob.getJobCategory()) {
						profiles = profileDetailsRepo.findAllByfilterCriteriaCli(jobProfileUpper, email, startExp,
								endExp, budget);
					} else {
						profiles = profileDetailsRepo.findAllByfilterCriteriaCli(searchJob.getJobCategory(),
								jobProfileUpper, email, startExp, endExp, budget);
					}
				} else if (null != jobProfileUpper && jobProfileUpper.size() > 0
						&& !(searchJob.getNoticePeriod() == 0)) {
					profiles = profileDetailsRepo.findAllByfilterCriteriaCli(searchJob.getJobCategory(),
							jobProfileUpper, email, startExp, endExp, searchJob.getNoticePeriod(), budget);

				} else if (null != jobProfileUpper && !(jobProfileUpper.size() > 0)
						&& (searchJob.getNoticePeriod() == 0)) {
					if (null == searchJob.getJobCategory()) {
						profiles = profileDetailsRepo.findAllByJobCatCli(email, startExp, endExp, budget);
					} else {
						profiles = profileDetailsRepo.findAllByJobCatCli(searchJob.getJobCategory(), email, startExp,
								endExp, budget);
					}
				} else if (null != jobProfileUpper && !(jobProfileUpper.size() > 0)
						&& !(searchJob.getNoticePeriod() == 0)) {
					profiles = profileDetailsRepo.findAllByJobCat(searchJob.getJobCategory(), email, startExp, endExp,
							searchJob.getNoticePeriod(), budget);
				}

				Iterator<ProfileDetails> itr2 = profiles.iterator();
				while (itr2.hasNext()) {
					ProfileDetails profileDetails = itr2.next();
					ProfileSummary profilSummary = new ProfileSummary();
					profilSummary.setProfileId(profileDetails.getProfileId());
					profilSummary.setFirstName(profileDetails.getFirstName());
					profilSummary.setLastName(profileDetails.getLastName());
					profilSummary.setPhone(profileDetails.getPhone());
					profilSummary.setEmail(profileDetails.getEmail());
					profilSummary.setCurrentCompany(profileDetails.getCurrentCompany());
					profilSummary.setDesignation(profileDetails.getDesignation());
					profilSummary.setLocation(profileDetails.getLocation());
					profilSummary.setCurrentCTC(profileDetails.getCurrentCTC());
					profilSummary.setExpectedCTC(profileDetails.getExpectedCTC());
					profilSummary.setOverallExp(profileDetails.getOverallExp());
					profilSummary.setRelevantExp(profileDetails.getRelevantExp());
					profilSummary.setOverAllRating(profileDetails.getOverAllRating());
					profilSummary.setJobCategory(profileDetails.getJobCategory());
					profilSummary.setSelectedBy(profileDetails.getSelectedBy());
					profileSummaryList.add(profilSummary);
				}
			} else if (null != user && null != user.getRole() && user.getRole().equalsIgnoreCase("Admin")) {
				profiles = profileDetailsRepo.findAll();
				Iterator<ProfileDetails> itr2 = profiles.iterator();
				while (itr2.hasNext()) {
					ProfileDetails profileDetails = itr2.next();
					ProfileSummary profilSummary = new ProfileSummary();
					profilSummary.setProfileId(profileDetails.getProfileId());
					profilSummary.setFirstName(profileDetails.getFirstName());
					profilSummary.setLastName(profileDetails.getLastName());
					profilSummary.setPhone(profileDetails.getPhone());
					profilSummary.setEmail(profileDetails.getEmail());
					profilSummary.setCurrentCompany(profileDetails.getCurrentCompany());
					profilSummary.setDesignation(profileDetails.getDesignation());
					profilSummary.setLocation(profileDetails.getLocation());
					profilSummary.setCurrentCTC(profileDetails.getCurrentCTC());
					profilSummary.setExpectedCTC(profileDetails.getExpectedCTC());
					profilSummary.setOverallExp(profileDetails.getOverallExp());
					profilSummary.setRelevantExp(profileDetails.getRelevantExp());
					profilSummary.setOverAllRating(profileDetails.getOverAllRating());
					profilSummary.setJobCategory(profileDetails.getJobCategory());
					profilSummary.setSelectedBy(profileDetails.getSelectedBy());
					profileSummaryList.add(profilSummary);
				}
			}
		} catch (JsonParseException jsonException) {
			jsonException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileSummaryList;
	}

	@Override
	public ProfileDetails getProfileByProfileId(String profileId) {
		ProfileDetails profile = null;
		try {
			profile = profileDetailsRepo.findByProfileId(profileId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
	}

	@Override
	public List<ProfileDetails> getProfilesSelected(String selectedBy) {
		List<ProfileDetails> profilesList = new ArrayList<ProfileDetails>();
		User user = null;
		try {
			user = userRepository.findByEmail(selectedBy);

			if (null != user && null != user.getRole() && null != user.getCompany()
					&& user.getRole().equalsIgnoreCase("Client")) {
				profilesList = profileDetailsRepo.findAllBySelectedBy(user.getCompany());
			} else if (null != user && null != user.getRole() && (user.getRole().equalsIgnoreCase("Recruiter"))) {
				profilesList = profileDetailsRepo.findAllSelected(user.getEmail());
			} else if (null != user && null != user.getRole() && user.getRole().equalsIgnoreCase("Admin")) {
				profilesList = profileDetailsRepo.findAll();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return profilesList;
	}

	@Override
	public ProfileDetails addProfile(ProfileDetails profile, MultipartFile profilePicture, MultipartFile resume,
			MultipartFile interviewVideo) {
		List<ProfileDetails> alreadyProfileExist = null;
		try {

			alreadyProfileExist = profileDetailsRepo.findByPhone(profile.getPhone());

			if (null != alreadyProfileExist) {
				profile.setProfileId(UUID.randomUUID() + "");
				DoubleStream doubleStream = DoubleStream.of(profile.getDataEngR(), profile.getCloudEngR(),
						profile.getProgrammingR(), profile.getCommunicationR(), profile.getAttitudeR());
				OptionalDouble res = doubleStream.average();
				profile.setOverAllRating(res.getAsDouble());
				if (null == profile.getJobCategory()) {
					profile.setJobCategory("fulltime");
				}

				Set<String> jobProfile = new HashSet<String>();
				if (null != profile.getSummary()) {
					List<String> skills = profile.getSummary().getSkills();
					if (null != skills) {
						skills.replaceAll(String::toUpperCase);
						skills.replaceAll(String::trim);
						jobProfile.addAll(skills);
					}

				}
				if (null != profile.getDesignation()) {
					jobProfile.add(profile.getDesignation().toUpperCase().trim());
				}
				if (null != profile.getFirstName() && null != profile.getLastName()) {
					jobProfile.add(profile.getFirstName().toUpperCase().trim());
					jobProfile.add(profile.getLastName().toUpperCase().trim());

				}

				profile.setJobProfile(jobProfile);

				if (null != profilePicture && !profilePicture.getOriginalFilename().equals("")) {
					String profilePictureURL = uploadFileToS3(profilePicture, profile.getProfileId(), "pic.png");
					profile.setProfilePic(profilePictureURL);
				}
				if (null != resume && !resume.getOriginalFilename().equals("")) {
					String resumeURL = uploadFileToS3(resume, profile.getProfileId(), "resume.pdf");
					profile.setResumeLink(resumeURL);
				}
				if (null != interviewVideo && !interviewVideo.getOriginalFilename().equals("")) {
					String interviewVideoURL = uploadFileToS3(interviewVideo, profile.getProfileId(), "video");
					profile.setVideoLink(interviewVideoURL);
				}
				if (null != profile.getSelectedBy() && profile.getSelectedBy().equalsIgnoreCase("")) {
					profile.setSelectedBy(null);
				}
				profileDetailsRepo.save(profile);
			} else {
				profile = new ProfileDetails();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
	}

	private String uploadFileToS3(MultipartFile file, String UUID, String type) {
		String awsS3URL = "";
		List<String> filesList = null;
		try {
			String uniqueFileName = UUID.toString() + "-" + type;
			awsS3URL = "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + uniqueFileName;
			filesList = listFiles(bucketName);
			if (!filesList.contains(awsS3URL)) {

				Path tempFile = Files.createTempFile(null, null);
				file.transferTo(tempFile);

				PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(uniqueFileName)
						.build();

				s3Client.putObject(putObjectRequest, tempFile);
			} else {
				awsS3URL = "";
			}

		} catch (S3Exception s3E) {

			return "Error uploading file: " + s3E.getMessage();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return awsS3URL;
	}

	private List<String> listFiles(String bucketName) {
		try {
			ListObjectsV2Request listObjectsRequest = ListObjectsV2Request.builder().bucket(bucketName).build();

			ListObjectsV2Response listObjectsResponse = s3Client.listObjectsV2(listObjectsRequest);

			return listObjectsResponse.contents().stream().map(S3Object::key).collect(Collectors.toList());
		} catch (S3Exception e) {
			System.err.println("Failed to list files: " + e.awsErrorDetails().errorMessage());
			throw e;
		}
	}

	@Override
	public boolean editProfile(ProfileDetails profile, MultipartFile profilePicture, MultipartFile resume,
			MultipartFile interviewVideo) {
		boolean editStatus = false;
		Long deleteStatus = 0L;
		ProfileDetails profileDetails = null;
		try {

			DoubleStream doubleStream = DoubleStream.of(profile.getDataEngR(), profile.getCloudEngR(),
					profile.getProgrammingR(), profile.getCommunicationR(), profile.getAttitudeR());
			OptionalDouble res = doubleStream.average();
			profile.setOverAllRating(res.getAsDouble());

			if (null == profile.getJobCategory()) {
				profile.setJobCategory("fulltime");
			}

			Set<String> jobProfile = new HashSet<String>();
			if (null != profile.getSummary()) {
				List<String> skills = profile.getSummary().getSkills();
				if (null != skills) {
					skills.replaceAll(String::toUpperCase);
					skills.replaceAll(String::trim);
					jobProfile.addAll(skills);
				}

			}
			if (null != profile.getDesignation()) {
				jobProfile.add(profile.getDesignation().toUpperCase().trim());
			}
			if (null != profile.getFirstName() && null != profile.getLastName()) {
				jobProfile.add(profile.getFirstName().toUpperCase().trim());
				jobProfile.add(profile.getLastName().toUpperCase().trim());

			}

			profile.setJobProfile(jobProfile);

			if (null != profilePicture && !profilePicture.getOriginalFilename().equals("")) {
				String profilePictureURL = uploadFileToS3(profilePicture, profile.getProfileId(), "pic.png");
				profile.setProfilePic(profilePictureURL);
			}
			if (null != resume && !resume.getOriginalFilename().equals("")) {
				String resumeURL = uploadFileToS3(resume, profile.getProfileId(), "resume.pdf");
				profile.setResumeLink(resumeURL);
			}
			if (null != interviewVideo && !interviewVideo.getOriginalFilename().equals("")) {
				String interviewVideoURL = uploadFileToS3(interviewVideo, profile.getProfileId(), "video");
				profile.setVideoLink(interviewVideoURL);
			}

			deleteStatus = profileDetailsRepo.deleteByProfileId(profile.getProfileId());
			if (!deleteStatus.equals(0)) {
				profileDetails = profileDetailsRepo.save(profile);
			}
			if (null != profileDetails) {
				editStatus = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return editStatus;
	}

	@Override
	public boolean deleteProfile(String profileId) {
		boolean deleteStatus = false;
		Long deleteStatusL = 0L;
		try {
			deleteStatusL = profileDetailsRepo.deleteByProfileId(profileId);
			if (!deleteStatusL.equals(0)) {
				deleteStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}

	@Override
	public boolean selectProfile(String profileId, String selectedBy) {
		boolean selectStatus = false;
		Long deleteStatusL = 0L;
		ProfileDetails profile = null;
		User user = null;
		try {
			user = userRepository.findByEmail(selectedBy);
			if (null != user && null != user.getCompany()) {
				profile = profileDetailsRepo.findByProfileId(profileId);
				if (null != profile) {
					deleteStatusL = profileDetailsRepo.deleteByProfileId(profile.getProfileId());
					if (null != deleteStatusL) {
						profile.setSelectedBy(user.getCompany());
						profile.setSelectedDateTime(LocalDateTime.now());
						profileDetailsRepo.save(profile);
						selectStatus = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectStatus;
	}

	@Override
	public List<JobProfiles> getJobProfiles(String jobCategory) {
		List<JobProfiles> jobProfiles = null;
		try {
			jobProfiles = jobProfileRepo.findByJobCategory(jobCategory);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobProfiles;
	}

	@Override
	public boolean addJobProfiles(JobProfiles jobProfiles) {
		boolean addStatus = false;
		try {
			jobProfiles.setId(UUID.randomUUID() + "");
			jobProfiles = jobProfileRepo.save(jobProfiles);
			addStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addStatus;
	}

	@Override
	public JobDescription getJobDescription(String jobCategory, String jobCategoryCode) {
		JobDescription jobDescription = null;
		try {
			jobDescription = jobDescriptionRepo.findByCategory(jobCategory, jobCategoryCode);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jobDescription;
	}

	@Override
	public boolean addJobDescription(JobDescription jobDescription) {
		boolean addStatus = false;
		JobDescription jobDescriptionAlready = null;
		try {
			jobDescriptionAlready = jobDescriptionRepo.findByCategory(jobDescription.getJobCategory(),
					jobDescription.getJobCategoryCode());
			if (null != jobDescriptionAlready) {
				jobDescriptionRepo.deleteById(jobDescriptionAlready.getId());
			}
			jobDescription.setId(UUID.randomUUID() + "");
			jobDescription = jobDescriptionRepo.save(jobDescription);
			addStatus = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return addStatus;
	}

	/*
	 * private void CustomeChanges() {
	 * 
	 * List<ProfileDetails> profilesTest = profileDetailsRepo.findAll();
	 * 
	 * Iterator<ProfileDetails> itr = profilesTest.iterator(); int count = 0;
	 * while(itr.hasNext()) { System.out.println("Count :: " + count);
	 * ProfileDetails details = itr.next(); Set<String> jobProfile =
	 * details.getJobProfile(); Iterator<String> itrJP = jobProfile.iterator();
	 * Set<String> tempJobProfile = new HashSet<String>(); while(itrJP.hasNext()) {
	 * String jp = itrJP.next(); tempJobProfile.add(jp.trim()); }
	 * 
	 * details.setJobProfile(tempJobProfile);
	 * 
	 * profileDetailsRepo.deleteByProfileId(details.getProfileId());
	 * profileDetailsRepo.save(details); count++; } System.out.println("Completed");
	 * }
	 */

	@Override
	public boolean updateJobProfiles(JobProfiles jobProfiles) {
		boolean updateStatus = false;
		try {
			jobProfileRepo.deleteById(jobProfiles.getId());
			jobProfiles = jobProfileRepo.save(jobProfiles);
			updateStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateStatus;
	}

	@Override
	public boolean deleteJobProfiles(String jobCategory, String categoryCode) {
		boolean deleteStatus = false;
		try {
			JobProfiles jobProfilesDelete = jobProfileRepo.findByCategoryCode(jobCategory, categoryCode);
			jobProfileRepo.deleteById(jobProfilesDelete.getId());
			deleteStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;
	}

	@Override
	public boolean updateJobDescription(JobDescription jobDescription) {
		boolean updateStatus = false;
		try {
			jobDescriptionRepo.deleteById(jobDescription.getId());
			jobDescriptionRepo.save(jobDescription);
			updateStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateStatus;
	}

}
