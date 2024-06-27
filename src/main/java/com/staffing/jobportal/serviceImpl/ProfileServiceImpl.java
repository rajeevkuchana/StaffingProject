package com.staffing.jobportal.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileDetails.ProfileStatus;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	private List<ProfileDetails> profiles = new ArrayList<>();

	public List<ProfileSummary> getAllProfiles() {
//        if ("Client".equalsIgnoreCase(role)) {
//            return profiles.stream()
//                    .filter(profile -> profile.getStatus() == status)
//                    .collect(Collectors.toList());
//        } else if ("Interviewer".equalsIgnoreCase(role)) {
//            return profiles.stream()
//                    .filter(profile -> profile.getInterviewBy().equalsIgnoreCase(createdBy))
//                    .collect(Collectors.toList());
//        }
		List<ProfileSummary> profileSummaryList = new ArrayList<>();
		try {
			Iterator<ProfileDetails> itr = profiles.iterator();
			while (itr.hasNext()) {
				ProfileDetails profileDetails = itr.next();
				ProfileSummary profilSummary = new ProfileSummary();
				profilSummary.setProfileId(profileDetails.getProfileId());
				profilSummary.setFirstName(profileDetails.getFirstName());
				profilSummary.setLastName(profileDetails.getLastName());
				profilSummary.setEmail(profileDetails.getEmail());
				profilSummary.setPhone(profileDetails.getPhone());
				profilSummary.setLocation(profileDetails.getLocation());
				profilSummary.setProfilePic(profileDetails.getProfilePic());
				profilSummary.setOverAllRating(profileDetails.getOverAllRating());
				profilSummary.setInterviewBy(profileDetails.getInterviewBy());
				profilSummary.setInterviewDateTime(profileDetails.getInterviewDateTime());
				profilSummary.setManagedBy(profileDetails.getManagedBy());
				profileSummaryList.add(profilSummary);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profileSummaryList; // Return empty list if role is neither Client nor Interviewer
	}

	public ProfileDetails getProfileById(String id) {
		return profiles.stream().filter(profile -> profile.getProfileId().equals(id)).findFirst().orElse(null);
	}

	public List<ProfileDetails> getProfilesClientSelected(ProfileStatus status) {
		return profiles.stream().filter(profile -> profile.getStatus() == status).collect(Collectors.toList());
	}

	public ProfileDetails addProfile(ProfileDetails profile) {
		// Generate ID (in a real application, this should be handled by database
		// auto-increment)
		try {
			profile.setProfileId(UUID.randomUUID()+"");
			profiles.add(profile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profile;
	}

	public void deleteProfile(String id) {
		profiles.removeIf(profile -> profile.getProfileId().equals(id));
	}

	public ProfileDetails editProfile(Long id, ProfileDetails updatedProfile) {
		ProfileDetails profile = profiles.stream().filter(p -> p.getProfileId().equals(id)).findFirst().orElse(null);

		if (profile != null) {
			// Update profile fields as needed
			profile.setFirstName(updatedProfile.getFirstName());
			profile.setLastName(updatedProfile.getLastName());
			// Update other fields similarly
		}

		return profile;
	}

	public ProfileDetails selectProfile(Long id, String selectedBy) {
		ProfileDetails profile = profiles.stream().filter(p -> p.getProfileId().equals(id)).findFirst().orElse(null);

		if (profile != null) {
			profile.setStatus(ProfileStatus.SELECTED);
			profile.setSelectedBy(selectedBy);
			profile.setSelectedDateTime(LocalDateTime.now());
		}

		return profile;
	}

	// Other methods as needed

}
