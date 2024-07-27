package com.staffing.jobportal.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.UUID;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.repo.ProfileDetailsRepo;
import com.staffing.jobportal.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	// private List<ProfileDetails> profiles = new ArrayList<>();
	@Autowired
	private ProfileDetailsRepo profileDetailsRepo;

	@Override
	public List<ProfileSummary> getAllProfiles() {

		List<ProfileDetails> profiles = profileDetailsRepo.findAll();

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

			DoubleStream doubleStream = DoubleStream.of(50.8, 35.7, 49.5, 12.7, 89.7, 97.4);
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
