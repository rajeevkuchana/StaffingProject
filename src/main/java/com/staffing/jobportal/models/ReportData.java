package com.staffing.jobportal.models;

import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.Document;

//User.java
@Document(collection = "ReportData")
public class ReportData {

	private String client;
	private String company;
	private String profileID;
	private String designation;
	private Date viewtime;
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProfileID() {
		return profileID;
	}
	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getViewtime() {
		return viewtime;
	}
	public void setViewtime(Date viewtime) {
		this.viewtime = viewtime;
	}
	

	

	// Constructors, getters, setters
}
