package com.staffing.jobportal.service;

import java.util.List;

import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;

public interface ProfileService {

	public List<ProfileSummary> getAllProfiles() ;

	public ProfileDetails getProfileByProfileId(String id);

	public List<ProfileDetails> getProfilesClientSelected(String email);

	public ProfileDetails addProfile(ProfileDetails profile);

	public boolean deleteProfile(String id);

	public boolean editProfile(String profileId, ProfileDetails updatedProfile);

	public boolean selectProfile(String profileId, String selectedBy);

}
