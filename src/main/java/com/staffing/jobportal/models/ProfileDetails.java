package com.staffing.jobportal.models;

import java.time.LocalDateTime;

//Profile.java
public class ProfileDetails {
	private String profileId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String location;
	private String profilePic;
	private double rating1;
	private double rating2;
	private double rating3;
	private double rating4;
	private double rating5;
	private double overAllRating;
	private BasicDetails basicDetails;
	private ExperienceDetails experienceDetails;
	private Feedback feedback;
	private String videoLink;
	private String resumeLink;
	private String interviewBy;
	private LocalDateTime interviewDateTime;
	private String managedBy;
	private ProfileStatus status;
	private String selectedBy;
	private LocalDateTime selectedDateTime;

	// Getters and Setters
	// Constructors
	// toString method
	// Other methods as needed

	public enum ProfileStatus {
		UPLOADED, SCREENED, PENDING_INTERVIEW, INTERVIEWED, SELECTED, RECRUITED, REJECTED
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public BasicDetails getBasicDetails() {
		return basicDetails;
	}

	public void setBasicDetails(BasicDetails basicDetails) {
		this.basicDetails = basicDetails;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public double getRating1() {
		return rating1;
	}

	public void setRating1(double rating1) {
		this.rating1 = rating1;
	}

	public double getRating2() {
		return rating2;
	}

	public void setRating2(double rating2) {
		this.rating2 = rating2;
	}

	public double getRating3() {
		return rating3;
	}

	public void setRating3(double rating3) {
		this.rating3 = rating3;
	}

	public double getRating4() {
		return rating4;
	}

	public void setRating4(double rating4) {
		this.rating4 = rating4;
	}

	public double getRating5() {
		return rating5;
	}

	public void setRating5(double rating5) {
		this.rating5 = rating5;
	}

	public double getOverAllRating() {
		return overAllRating;
	}

	public void setOverAllRating(double overAllRating) {
		this.overAllRating = overAllRating;
	}

	public ExperienceDetails getExperienceDetails() {
		return experienceDetails;
	}

	public void setExperienceDetails(ExperienceDetails experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getResumeLink() {
		return resumeLink;
	}

	public void setResumeLink(String resumeLink) {
		this.resumeLink = resumeLink;
	}

	public String getInterviewBy() {
		return interviewBy;
	}

	public void setInterviewBy(String interviewBy) {
		this.interviewBy = interviewBy;
	}

	public LocalDateTime getInterviewDateTime() {
		return interviewDateTime;
	}

	public void setInterviewDateTime(LocalDateTime interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}

	public String getManagedBy() {
		return managedBy;
	}

	public void setManagedBy(String managedBy) {
		this.managedBy = managedBy;
	}

	public ProfileStatus getStatus() {
		return status;
	}

	public void setStatus(ProfileStatus status) {
		this.status = status;
	}

	public String getSelectedBy() {
		return selectedBy;
	}

	public void setSelectedBy(String selectedBy) {
		this.selectedBy = selectedBy;
	}

	public LocalDateTime getSelectedDateTime() {
		return selectedDateTime;
	}

	public void setSelectedDateTime(LocalDateTime selectedDateTime) {
		this.selectedDateTime = selectedDateTime;
	}

}

//ProfileStatus.java (Enum for profile status)
