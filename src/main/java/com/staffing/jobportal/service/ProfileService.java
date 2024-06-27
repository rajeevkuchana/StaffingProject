package com.staffing.jobportal.service;

import java.util.List;

import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.models.ProfileDetails.ProfileStatus;

public interface ProfileService {

	public List<ProfileSummary> getAllProfiles();

	public ProfileDetails getProfileById(String id);

	public List<ProfileDetails> getProfilesClientSelected(ProfileStatus status);

	public ProfileDetails addProfile(ProfileDetails profile);

	public void deleteProfile(String id);

	public ProfileDetails editProfile(Long id, ProfileDetails updatedProfile);

	public ProfileDetails selectProfile(Long id, String selectedBy);

}
