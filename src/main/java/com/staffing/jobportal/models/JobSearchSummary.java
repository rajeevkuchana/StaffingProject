package com.staffing.jobportal.models;

import java.util.List;

public class JobSearchSummary {

	List<ProfileSummary> profileList;
	
	JobDetails jobDetails;

	public List<ProfileSummary> getProfileList() {
		return profileList;
	}

	public void setProfileList(List<ProfileSummary> profileList) {
		this.profileList = profileList;
	}

	public JobDetails getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}
	
	

}
