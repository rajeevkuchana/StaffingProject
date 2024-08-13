package com.staffing.jobportal.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

//User.java
@Document(collection = "jobProfiles")
public class JobProfiles {

	private String id;

	private String jobCategory;

	private String categoryCode;

	private String categoryDisplay;

	private String CategoryDescriptions;

	private String categoryIcon;

	private List<JobProfilesSubCat> jobProfilesSubCats;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryDisplay() {
		return categoryDisplay;
	}

	public void setCategoryDisplay(String categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}

	public String getCategoryDescriptions() {
		return CategoryDescriptions;
	}

	public void setCategoryDescriptions(String categoryDescriptions) {
		CategoryDescriptions = categoryDescriptions;
	}

	public String getCategoryIcon() {
		return categoryIcon;
	}

	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}

	public List<JobProfilesSubCat> getJobProfilesSubCats() {
		return jobProfilesSubCats;
	}

	public void setJobProfilesSubCats(List<JobProfilesSubCat> jobProfilesSubCats) {
		this.jobProfilesSubCats = jobProfilesSubCats;
	}

}
