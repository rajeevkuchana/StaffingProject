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
	private String education;
	private String nationality;
	private String email;
	private String phone;
	private String location;
	private String profilePic;
	private String currentCompany;
	private int expectedCTC;
	private int currentCTC;
	private int overallExp;
	private int relevantExp;
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
	private ExperienceDetails experienceDetails;
	private Feedback feedback;
	private String videoLink;
	private String resumeLink;
	private String interviewBy;
	private LocalDateTime interviewDateTime;
	private String managedBy;
	private String status;
	private String selectedBy;
	private int noticePeriod;
	private LocalDateTime selectedDateTime;
	private String matchPer;
	
	
	public String getMatchPer() {
		return matchPer;
	}
	public void setMatchPer(String matchPer) {
		this.matchPer = matchPer;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getCurrentCompany() {
		return currentCompany;
	}
	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}
	public int getExpectedCTC() {
		return expectedCTC;
	}
	public void setExpectedCTC(int expectedCTC) {
		this.expectedCTC = expectedCTC;
	}
	public int getCurrentCTC() {
		return currentCTC;
	}
	public void setCurrentCTC(int currentCTC) {
		this.currentCTC = currentCTC;
	}
	public int getOverallExp() {
		return overallExp;
	}
	public void setOverallExp(int overallExp) {
		this.overallExp = overallExp;
	}
	public int getRelevantExp() {
		return relevantExp;
	}
	public void setRelevantExp(int relevantExp) {
		this.relevantExp = relevantExp;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSelectedBy() {
		return selectedBy;
	}
	public void setSelectedBy(String selectedBy) {
		this.selectedBy = selectedBy;
	}
	public int getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public LocalDateTime getSelectedDateTime() {
		return selectedDateTime;
	}
	public void setSelectedDateTime(LocalDateTime selectedDateTime) {
		this.selectedDateTime = selectedDateTime;
	}		
}


