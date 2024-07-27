package com.staffing.jobportal.models;

import org.springframework.data.mongodb.core.mapping.Document;

//User.java
@Document(collection = "users")
public class User {

	private String id;
	private String username;
	private String email;
	private String role;
	private String password;
	private String company;

	public User(String id, String username, String email, String role, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Constructors, getters, setters
}
