package com.staffing.jobportal.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.UUID;
import java.util.stream.DoubleStream;

import org.bson.json.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffing.jobportal.models.JobSearchSummary;
import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.models.SearchJob;
import com.staffing.jobportal.models.User;
import com.staffing.jobportal.repo.ProfileDetailsRepo;
import com.staffing.jobportal.repo.UserRepo;
import com.staffing.jobportal.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private UserRepo userRepository;
	// private List<ProfileDetails> profiles = new ArrayList<>();
	@Autowired
	private ProfileDetailsRepo profileDetailsRepo;

	@Override
	public JobSearchSummary getAllProfiles(SearchJob searchJob) {

		JobSearchSummary jobSearchSummary = new JobSearchSummary();
		List<ProfileSummary> profileSummaryList = new ArrayList<>();
		List<ProfileDetails> profiles = null;
		String email = searchJob.getEmail();
		User user = null;
		String company = null;
		
		try {
			
			user = userRepository.findByEmail(email);
			company = user.getCompany();
			if (null != searchJob.getJobProfile() && searchJob.getJobProfile().size() > 0) {

				profiles = profileDetailsRepo.findAllByfilterCriteria(searchJob.getJobCategory(),
						searchJob.getJobProfile(), company);
			} else {
				profiles = profileDetailsRepo.findAllByJobCat(searchJob.getJobCategory(), company);
			}

			Iterator<ProfileDetails> itr = profiles.iterator();
			while (itr.hasNext()) {
				ProfileDetails profileDetails = itr.next();
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
				
				profileSummaryList.add(profilSummary);
			}
			
			jobSearchSummary.setProfileList(profileSummaryList);
		} catch (JsonParseException jsonException) {
			jsonException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobSearchSummary; 
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
	public List<ProfileDetails> getProfilesClientSelected(String selectedBy) {
		List<ProfileDetails> profilesList = new ArrayList<ProfileDetails>();
		try {
			profilesList = profileDetailsRepo.findAllBySelectedBy(selectedBy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profilesList;
	}

	@Override
	public ProfileDetails addProfile(ProfileDetails profile) {

		try {
			profile.setProfileId(UUID.randomUUID() + "");
			DoubleStream doubleStream = DoubleStream.of(profile.getRating1(), profile.getRating2(),
					profile.getRating3(), profile.getRating4(), profile.getRating5());
			OptionalDouble res = doubleStream.average();
			profile.setOverAllRating(res.getAsDouble());

			profileDetailsRepo.save(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
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
	public boolean editProfile(String profileId, ProfileDetails updatedProfile) {
		boolean editStatus = false;
		Long deleteStatus = 0L;
		try {
			deleteStatus = profileDetailsRepo.deleteByProfileId(profileId);
			if (!deleteStatus.equals(0)) {
				updatedProfile.setProfileId(profileId);
				ProfileDetails profileDetails = profileDetailsRepo.save(updatedProfile);
				if (null != profileDetails) {
					editStatus = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return editStatus;
	}

	@Override
	public boolean selectProfile(String profileId, String selectedBy) {
		boolean selectStatus = false;
		ProfileDetails profile = null;
		try {
			profile = profileDetailsRepo.findByProfileId(profileId);
			profile.setSelectedBy(selectedBy);
			profileDetailsRepo.save(profile);
			selectStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectStatus;
	}

}
