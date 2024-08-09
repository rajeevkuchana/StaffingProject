package com.staffing.jobportal.models;

import org.springframework.data.mongodb.core.mapping.Document;

//User.java
@Document(collection = "jobDescription")
public class JobDescription {

	private String jobDescriptionText;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobDescription() {
		return jobDescriptionText;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescriptionText = jobDescription;
	}

}
