package com.staffing.jobportal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.staffing.jobportal.models.JobProfiles;
import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.models.SearchJob;
import com.staffing.jobportal.service.ProfileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin(origins = { "http://localhost:3000" }, methods = { RequestMethod.OPTIONS, RequestMethod.GET,
		RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST })
@RestController
@RequestMapping("/profiles")
@Api(tags = "Profile Management", description = "Endpoints for managing profiles")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@PostMapping("")
	@ApiOperation("Get all profiles based on role and status")
	public List<ProfileSummary> getAllProfiles(
	// @ApiParam(value = "email", required = true) @RequestParam(value = "email")
	// String email
//            @ApiParam(value = "Role (Client or Interviewer)", required = true) @RequestParam(value = "role") String role,
//            @ApiParam(value = "Created by (for Interviewer role)", required = false) @RequestParam(value = "createdBy", required = false) String createdBy,
//            @ApiParam(value = "Status", required = true, allowableValues = "UPLOADED, SCREENED, PENDING_INTERVIEW, INTERVIEWED, SELECTED, RECRUITED, REJECTED")
			@ApiParam(value = "Profile object to be added", required = true) @RequestBody SearchJob searchJob
//            @RequestParam(value = "status") ProfileStatus status
	) {

		List<ProfileSummary> profileList = new ArrayList<ProfileSummary>();

		ProfileSummary profileSummary = new ProfileSummary();
		profileSummary.setProfileId("ee728662-7693-4444-ab1d-a84ffcdff8df");
		profileSummary.setFirstName("Sachin");
		profileSummary.setLastName("Ten");
		profileSummary.setCurrentCompany("TCS");
		profileSummary.setDesignation("Developer");
		profileSummary.setCurrentCTC("23-LPA");
		profileSummary.setExpectedCTC("30-LPA");
		profileSummary.setOverallExp("10-Years");
		profileSummary.setRelevantExp("8-Years");
		profileSummary.setOverAllRating(4);
		profileSummary.setLocation("Banglore");
		profileList.add(profileSummary);

		ProfileSummary profileSummary1 = new ProfileSummary();
		profileSummary1.setProfileId("67dacf62-c323-4929-b44d-21985a362bc3");
		profileSummary1.setFirstName("SachinA");
		profileSummary1.setLastName("TenA");
		profileSummary1.setCurrentCompany("WIPRO");
		profileSummary1.setDesignation("Sr Developer");
		profileSummary1.setCurrentCTC("35-LPA");
		profileSummary1.setExpectedCTC("40-LPA");
		profileSummary1.setOverallExp("15-Years");
		profileSummary1.setRelevantExp("12-Years");
		profileSummary1.setLocation("Mumbai");
		profileSummary1.setOverAllRating(3);
		profileList.add(profileSummary1);

		ProfileSummary profileSummary2 = new ProfileSummary();
		profileSummary2.setProfileId("831b4047-c10a-4642-8b7b-59de8df89f38");
		profileSummary2.setFirstName("Rahul");
		profileSummary2.setLastName("TenA");
		profileSummary2.setCurrentCompany("TCS");
		profileSummary2.setDesignation("DevOps");
		profileSummary2.setCurrentCTC("25-LPA");
		profileSummary2.setExpectedCTC("30-LPA");
		profileSummary2.setOverallExp("5-Years");
		profileSummary2.setRelevantExp("5-Years");
		profileSummary2.setLocation("Hyderabad");
		profileSummary2.setOverAllRating(3);
		profileList.add(profileSummary2);

		ProfileSummary profileSummary3 = new ProfileSummary();
		profileSummary3.setProfileId("831b4047-c10a-4642-8b7b-59de8df89f38");
		profileSummary3.setFirstName("Ramesh");
		profileSummary3.setLastName("TenA");
		profileSummary3.setCurrentCompany("TEST");
		profileSummary3.setDesignation("QA");
		profileSummary3.setCurrentCTC("17-LPA");
		profileSummary3.setExpectedCTC("23-LPA");
		profileSummary3.setOverallExp("9-Years");
		profileSummary3.setRelevantExp("8-Years");
		profileSummary3.setOverAllRating(3);
		profileList.add(profileSummary3);

		return profileList;

	}

	@PostMapping("/add")
	@ApiOperation("Add a new profile")
	@ApiResponses({ @ApiResponse(code = 201, message = "Profile created successfully"),
			@ApiResponse(code = 400, message = "Invalid input data") })
	public ResponseEntity<ProfileDetails> addProfile(
			// @ApiParam(value = "email", required = true) @RequestParam(value = "email")
			// String email,
			@ApiParam(value = "Profile object to be added", required = true) @RequestBody ProfileDetails profile) {
		ProfileDetails addedProfile = profileService.addProfile(profile);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedProfile);
	}

	@GetMapping("/{profileId}")
	@ApiOperation("Get a profile by ID")
	public ResponseEntity<ProfileDetails> getProfileById(
			@ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable String profileId) {
		ProfileDetails profile = profileService.getProfileByProfileId(profileId);
		if (profile != null) {
			return ResponseEntity.ok(profile);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/jobProfiles")
	@ApiOperation("Get a profile by ID")
	public ResponseEntity<List<JobProfiles>> getJobProfiles(
			@ApiParam(value = "Profile ID", example = "1", required = true) @RequestParam String jobCategory) {
		List<JobProfiles> jobProfiles = new ArrayList<JobProfiles>();

		JobProfiles jobProfile = new JobProfiles();
		jobProfile.setId("sedfvfsddfsf");
		jobProfile.setJobProfiles("Cloud");
		jobProfile.setJobProfilesDisplay("Cloud");
		Map<String, String> profiles = new HashMap<String, String>();
		profiles.put("Azure Data Engineer", "AzureDE");
		profiles.put("AWS Data Engineer", "AWSDE");
		profiles.put("GCP Data Engineer", "GCPDE");
		profiles.put("ANY Cloud Data Engineer", "ANYCDE");
		profiles.put("MULTI Cloud Data Engineer", "MULTICDE");
		profiles.put("NO Cloud Data Engineer", "NOCDE");
		jobProfile.setJobProfileSub(profiles);
		jobProfiles.add(jobProfile);
		
		
		JobProfiles jobProfile1 = new JobProfiles();
		jobProfile1.setId("sedfvfsddfsf");
		jobProfile1.setJobProfiles("DataAI");
		jobProfile1.setJobProfilesDisplay("DATA & AI");
		Map<String, String> profiles1 = new HashMap<String, String>();
		jobProfile1.setJobProfileSub(profiles1);
		jobProfiles.add(jobProfile1);
		
		JobProfiles jobProfile2 = new JobProfiles();
		jobProfile2.setId("sedfvfsddfsf");
		jobProfile2.setJobProfiles("FullStack");
		jobProfile2.setJobProfilesDisplay("Full Stack");
		Map<String, String> profiles2 = new HashMap<String, String>();
		jobProfile2.setJobProfileSub(profiles2);
		jobProfiles.add(jobProfile2);
		
		JobProfiles jobProfile3 = new JobProfiles();
		jobProfile3.setId("sedfvfsddfsf");
		jobProfile3.setJobProfiles("QA");
		jobProfile3.setJobProfilesDisplay("Quality Assurance");
		Map<String, String> profiles3 = new HashMap<String, String>();
		jobProfile3.setJobProfileSub(profiles3);
		jobProfiles.add(jobProfile3);
		
		JobProfiles jobProfile4 = new JobProfiles();
		jobProfile4.setId("sedfvfsddfsf");
		jobProfile4.setJobProfiles("QA");
		jobProfile4.setJobProfilesDisplay("Quality Assurance");
		Map<String, String> profiles4 = new HashMap<String, String>();
		jobProfile4.setJobProfileSub(profiles4);
		jobProfiles.add(jobProfile4);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(jobProfiles);
	}

	@PostMapping("/add/jobProfile")
	@ApiOperation("Get a profile by ID")
	public ResponseEntity<Boolean> getJobProfiles(
			@ApiParam(value = "Job Profile", example = "1", required = true) @RequestBody JobProfiles jobProfile) {
		boolean addStatus = profileService.addJobProfiles(jobProfile);
		return ResponseEntity.status(HttpStatus.CREATED).body(addStatus);
	}

	@GetMapping("/clientSelected")
	@ApiOperation("Get profiles with selected status by client")
	public List<ProfileSummary> getProfilesClientSelected(
			@ApiParam(value = "email", required = true) @RequestParam(value = "email") String email) {
		List<ProfileSummary> profileList = new ArrayList<ProfileSummary>();

		ProfileSummary profileSummary = new ProfileSummary();

		profileSummary.setProfileId("ee728662-7693-4444-ab1d-a84ffcdff8df");
		profileSummary.setFirstName("Sachin");
		profileSummary.setLastName("Ten");
		profileSummary.setCurrentCompany("TCS");
		profileSummary.setDesignation("Developer");
		profileSummary.setCurrentCTC("23-LPA");
		profileSummary.setExpectedCTC("30-LPA");
		profileSummary.setOverallExp("10-Years");
		profileSummary.setRelevantExp("8-Years");
		profileSummary.setOverAllRating(4);
		profileList.add(profileSummary);

		profileSummary.setProfileId("67dacf62-c323-4929-b44d-21985a362bc3");
		profileSummary.setFirstName("SachinA");
		profileSummary.setLastName("TenA");
		profileSummary.setCurrentCompany("WIPRO");
		profileSummary.setDesignation("Sr Developer");
		profileSummary.setCurrentCTC("35-LPA");
		profileSummary.setExpectedCTC("40-LPA");
		profileSummary.setOverallExp("15-Years");
		profileSummary.setRelevantExp("12-Years");
		profileSummary.setOverAllRating(3);
		profileList.add(profileSummary);

		profileSummary.setProfileId("831b4047-c10a-4642-8b7b-59de8df89f38");
		profileSummary.setFirstName("Rahul");
		profileSummary.setLastName("TenA");
		profileSummary.setCurrentCompany("TCS");
		profileSummary.setDesignation("DevOps");
		profileSummary.setCurrentCTC("25-LPA");
		profileSummary.setExpectedCTC("30-LPA");
		profileSummary.setOverallExp("5-Years");
		profileSummary.setRelevantExp("5-Years");
		profileSummary.setOverAllRating(3);
		profileList.add(profileSummary);

		profileSummary.setProfileId("831b4047-c10a-4642-8b7b-59de8df89f38");
		profileSummary.setFirstName("Ramesh");
		profileSummary.setLastName("TenA");
		profileSummary.setCurrentCompany("TEST");
		profileSummary.setDesignation("QA");
		profileSummary.setCurrentCTC("17-LPA");
		profileSummary.setExpectedCTC("23-LPA");
		profileSummary.setOverallExp("9-Years");
		profileSummary.setRelevantExp("8-Years");
		profileSummary.setOverAllRating(3);
		profileList.add(profileSummary);

		return profileList;
	}

	@DeleteMapping("/delete/{profileId}")
	@ApiOperation("Delete a profile by ID")
	@ApiResponses({ @ApiResponse(code = 204, message = "Profile deleted successfully"),
			@ApiResponse(code = 404, message = "Profile not found") })
	public ResponseEntity<Void> deleteProfile(
			@ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable String profileId) {
		profileService.deleteProfile(profileId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/edit/{profileId}")
	@ApiOperation("Update a profile by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Profile updated successfully"),
			@ApiResponse(code = 404, message = "Profile not found") })
	public ResponseEntity<Boolean> editProfile(
			@ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable String profileId,
			@ApiParam(value = "Updated profile object", required = true) @RequestBody ProfileDetails updatedProfile) {

		boolean editStatus = profileService.editProfile(profileId, updatedProfile);
		return ResponseEntity.ok(editStatus);

	}

	@GetMapping("/select/{profileId}")
	@ApiOperation("Select a profile by ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Profile selected successfully"),
			@ApiResponse(code = 404, message = "Profile not found") })
	public ResponseEntity<Boolean> selectProfile(
			@ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable String profileId,
			@ApiParam(value = "Selected by (Client or Interviewer)", required = true) @RequestParam(value = "email") String email) {
		boolean selectActionStatus = profileService.selectProfile(profileId, email);

		return ResponseEntity.ok(selectActionStatus);
	}

}
