package com.staffing.jobportal.models;

import org.springframework.data.mongodb.core.mapping.Document;

//User.java
@Document(collection = "jobDescription")
public class JobDescription {

	private String jobDescriptionText;
	
	private String jobCategoryCode;
	
	private String jobCategory;
	
	private String id;

	public String getJobDescriptionText() {
		return jobDescriptionText;
	}

	public void setJobDescriptionText(String jobDescriptionText) {
		this.jobDescriptionText = jobDescriptionText;
	}

	public String getJobCategoryCode() {
		return jobCategoryCode;
	}

	public void setJobCategoryCode(String jobCategoryCode) {
		this.jobCategoryCode = jobCategoryCode;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
