package com.staffing.jobportal.models;

import java.util.List;

public class SearchJob {

	private String jobCategory;
	
	private List<String> jobProfile;
	
	private String experienceRange;
	
	private int noticePeriod;
	
	private int budget;
	
	private String email;

	
	public String getExperienceRange() {
		return experienceRange;
	}

	public void setExperienceRange(String experienceRange) {
		this.experienceRange = experienceRange;
	}

	public int getBudget() {
		return budget;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
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
