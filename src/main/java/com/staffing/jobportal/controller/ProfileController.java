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
		List<ProfileSummary> profileList = profileService.getAllProfiles(searchJob);
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
		List<JobProfiles> jobProfiles = profileService.getJobProfiles(jobCategory);
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
	public List<ProfileDetails> getProfilesClientSelected(
			@ApiParam(value = "email", required = true) @RequestParam(value = "email") String email) {
		List<ProfileDetails> profileList = profileService.getProfilesClientSelected(email);
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
