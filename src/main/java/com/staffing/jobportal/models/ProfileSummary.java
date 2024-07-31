package com.staffing.jobportal.models;

//Profile.java
public class ProfileSummary {
	
	private String profileId;
	private String firstName;
	private String lastName;
	private String currentCompany;
	private String designation;
	private String location;
	private String profilePic;
	private String currentCTC;
	private String expectedCTC;
	private String overallExp;
	private String relevantExp;
	private double overAllRating;

	public String getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(String expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	public String getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
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

}

//ProfileStatus.java (Enum for profile status)
