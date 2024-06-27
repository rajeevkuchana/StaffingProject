package com.staffing.jobportal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.staffing.jobportal.models.ProfileDetails;
import com.staffing.jobportal.models.ProfileDetails.ProfileStatus;
import com.staffing.jobportal.models.ProfileSummary;
import com.staffing.jobportal.service.ProfileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/profiles")
@Api(tags = "Profile Management", description = "Endpoints for managing profiles")
public class ProfileController {
//Comment

    @Autowired
    private ProfileService profileService;

    @GetMapping("")
    @ApiOperation("Get all profiles based on role and status")
    public List<ProfileSummary> getAllProfiles(
//            @ApiParam(value = "Role (Client or Interviewer)", required = true) @RequestParam(value = "role") String role,
//            @ApiParam(value = "Created by (for Interviewer role)", required = false) @RequestParam(value = "createdBy", required = false) String createdBy,
//            @ApiParam(value = "Status", required = true, allowableValues = "UPLOADED, SCREENED, PENDING_INTERVIEW, INTERVIEWED, SELECTED, RECRUITED, REJECTED")
//            @RequestParam(value = "status") ProfileStatus status
    		) {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a profile by ID")
    public ResponseEntity<ProfileDetails> getProfileById(
            @ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable String id) {
        ProfileDetails profile = profileService.getProfileById(id);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clientSelected")
    @ApiOperation("Get profiles with selected status by client")
    public List<ProfileDetails> getProfilesClientSelected(
            @ApiParam(value = "Status", required = true, allowableValues = "SELECTED") @RequestParam(value = "status") ProfileStatus status) {
        return profileService.getProfilesClientSelected(status);
    }

    @PostMapping("/add")
    @ApiOperation("Add a new profile")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Profile created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<ProfileDetails> addProfile(
            @ApiParam(value = "Profile object to be added", required = true) @RequestBody ProfileDetails profile) {
        ProfileDetails addedProfile = profileService.addProfile(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProfile);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a profile by ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Profile deleted successfully"),
            @ApiResponse(code = 404, message = "Profile not found")
    })
    public ResponseEntity<Void> deleteProfile(
            @ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable String id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    @ApiOperation("Update a profile by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Profile updated successfully"),
            @ApiResponse(code = 404, message = "Profile not found")
    })
    public ResponseEntity<ProfileDetails> editProfile(
            @ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable Long id,
            @ApiParam(value = "Updated profile object", required = true) @RequestBody ProfileDetails updatedProfile) {
        ProfileDetails editedProfile = profileService.editProfile(id, updatedProfile);
        if (editedProfile != null) {
            return ResponseEntity.ok(editedProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/select/{id}")
    @ApiOperation("Select a profile by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Profile selected successfully"),
            @ApiResponse(code = 404, message = "Profile not found")
    })
    public ResponseEntity<ProfileDetails> selectProfile(
            @ApiParam(value = "Profile ID", example = "1", required = true) @PathVariable Long id,
            @ApiParam(value = "Selected by (Client or Interviewer)", required = true) @RequestParam String selectedBy) {
        ProfileDetails selectedProfile = profileService.selectProfile(id, selectedBy);
        if (selectedProfile != null) {
            return ResponseEntity.ok(selectedProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other endpoints as needed

    @ApiIgnore // Swagger will ignore this endpoint
    @GetMapping("/ignore")
    public void ignoredEndpoint() {
        // Method implementation
    }

}
