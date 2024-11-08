package com.staffing.jobportal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.staffing.jobportal.models.JobDescription;
import com.staffing.jobportal.models.JobProfiles;
import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.models.SearchJob;

public interface ProfileService {

	public List<ProfileSummary> getAllProfiles(SearchJob searchJob) ;

	public ProfileDetails getProfileByProfileId(String id);

	public List<ProfileDetails> getProfilesClientSelected(String email);

	public ProfileDetails addProfile(ProfileDetails profile, MultipartFile profilePicture, MultipartFile resume, MultipartFile interviewVideo);

	public boolean deleteProfile(String id);

	public boolean editProfile(String profileId, ProfileDetails updatedProfile);

	public boolean selectProfile(String profileId, String selectedBy);
	
	public List<JobProfiles> getJobProfiles(String jobCategory) ;
	
	public boolean addJobProfiles(JobProfiles jobProfiles);
	
	public boolean updateJobProfiles(JobProfiles jobProfiles);
	
	public boolean deleteJobProfiles(String categoryCode);
	
	public boolean addJobDescription(JobDescription jobDescription);
	
	public boolean updateJobDescription(JobDescription jobDescription);
	
	public JobDescription getJobDescription(String jobCategory, String jobCategoryCode);
		
}
