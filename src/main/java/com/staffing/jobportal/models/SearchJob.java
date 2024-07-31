package com.staffing.jobportal.models;

import java.util.List;

public class SearchJob {

	private String jobCategory;
	
	private String jobType;
	
	private List<String> jobProfile;
	
	private String email;

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(List<String> jobProfile) {
		this.jobProfile = jobProfile;
	}
}
