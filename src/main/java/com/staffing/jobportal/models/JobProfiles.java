package com.staffing.jobportal.models;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

//User.java
@Document(collection = "jobProfiles")
public class JobProfiles {

	private String id;
	
	private String jobProfiles;
	
	private String jobProfilesDisplay;
	
	private Map<String, String> jobProfileSub;

	
	public String getJobProfilesDisplay() {
		return jobProfilesDisplay;
	}

	public void setJobProfilesDisplay(String jobProfilesDisplay) {
		this.jobProfilesDisplay = jobProfilesDisplay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobProfiles() {
		return jobProfiles;
	}

	public void setJobProfiles(String jobProfiles) {
		this.jobProfiles = jobProfiles;
	}

	public Map<String, String> getJobProfileSub() {
		return jobProfileSub;
	}

	public void setJobProfileSub(Map<String, String> jobProfileSub) {
		this.jobProfileSub = jobProfileSub;
	}

	
	

	// Constructors, getters, setters
}
