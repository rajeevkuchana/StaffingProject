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
	private int currentCTC;
	private int expectedCTC;
	private int overallExp;
	private int relevantExp;
	private double overAllRating;
	private String jobCategory;
	private String company;
	private String selectedBy;
	private String phone;
	private String email;
	private String matchPer;
	
	
	public String getMatchPer() {
		return matchPer;
	}

	public void setMatchPer(String matchPer) {
		this.matchPer = matchPer;
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

	public String getSelectedBy() {
		return selectedBy;
	}

	public void setSelectedBy(String selectedBy) {
		this.selectedBy = selectedBy;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC(int currentCTC) {
		this.currentCTC = currentCTC;
	}

	public int getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(int expectedCTC) {
		this.expectedCTC = expectedCTC;
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

	public double getOverAllRating() {
		return overAllRating;
	}

	public void setOverAllRating(double overAllRating) {
		this.overAllRating = overAllRating;
	}

}
