package com.staffing.jobportal.models;

//User.java
public class User {

	private Long id;
	private String username;
	private String email;
	private String role;
	private String password;

	public User(Long id, String username, String email, String role, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
