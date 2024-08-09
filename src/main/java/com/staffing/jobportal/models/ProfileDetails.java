package com.staffing.jobportal.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

//Profile.java
@Document(collection = "profiles")
public class ProfileDetails {
	
	
	//private String id;
	private String profileId;
	private String firstName;
	private String gender;
	private String lastName;
	private String email;
	private String phone;
	private String location;
	private String profilePic;
	private String currentCompany;
	private String expectedCTC;
	private String currentCTC;
	private String overallExp;
	private String relevantExp;
	private String designation;
	private Summary summary;
	private List<String> certificationList;
	private List<String> jobProfile;
	private String jobCategory;
	private double dataEngR;
	private double programmingR;
	private double cloudEngR;
	private double communicationR;
	private double attitudeR;
	private double overAllRating;
	private BasicDetails basicDetails;
	private ExperienceDetails experienceDetails;
	private Feedback feedback;
	private String videoLink;
	private String resumeLink;
	private String interviewBy;
	private LocalDateTime interviewDateTime;
	private String managedBy;
	private String status;
	private String selectedBy;
	private LocalDateTime selectedDateTime;

	
	public String getStatus() {
		return status;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public List<String> getCertificationList() {
		return certificationList;
	}

	public void setCertificationList(List<String> certificationList) {
		this.certificationList = certificationList;
	}

	public String getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC(String currentCTC) {
		this.currentCTC = currentCTC;
	}

	public String getOverallExp() {
		return overallExp;
	}

	public void setOverallExp(String overallExp) {
		this.overallExp = overallExp;
	}

	public String getRelevantExp() {
		return relevantExp;
	}

	public void setRelevantExp(String relevantExp) {
		this.relevantExp = relevantExp;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(String expectedCTC) {
		this.expectedCTC = expectedCTC;
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

	public List<String> getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(List<String> jobProfile) {
		this.jobProfile = jobProfile;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public double getDataEngR() {
		return dataEngR;
	}

	public void setDataEngR(double dataEngR) {
		this.dataEngR = dataEngR;
	}

	public double getProgrammingR() {
		return programmingR;
	}

	public void setProgrammingR(double programmingR) {
		this.programmingR = programmingR;
	}

	public double getCloudEngR() {
		return cloudEngR;
	}

	public void setCloudEngR(double cloudEngR) {
		this.cloudEngR = cloudEngR;
	}

	public double getCommunicationR() {
		return communicationR;
	}

	public void setCommunicationR(double communicationR) {
		this.communicationR = communicationR;
	}

	public double getAttitudeR() {
		return attitudeR;
	}

	public void setAttitudeR(double attitudeR) {
		this.attitudeR = attitudeR;
	}

	
}


