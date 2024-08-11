package com.staffing.jobportal.service;

import java.util.List;

import com.staffing.jobportal.models.JobDescription;
import com.staffing.jobportal.models.JobProfiles;
import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.models.SearchJob;

public interface ProfileService {

	public List<ProfileSummary> getAllProfiles(SearchJob searchJob) ;

	public ProfileDetails getProfileByProfileId(String id);

	public List<ProfileDetails> getProfilesClientSelected(String email);

	public ProfileDetails addProfile(ProfileDetails profile);

	public boolean deleteProfile(String id);

	public boolean editProfile(String profileId, ProfileDetails updatedProfile);

	public boolean selectProfile(String profileId, String selectedBy);
	
	public List<JobProfiles> getJobProfiles(String jobCategory) ;
	
	public boolean addJobProfiles(JobProfiles jobProfiles);
	
	public JobDescription getJobDescription(String jobCategory, String jobCategoryCode);
	
	public boolean addJobDescription(JobDescription jobDescription);
		
}
