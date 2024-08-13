package com.staffing.jobportal.models;

import java.util.List;

public class Summary {

	private String summary1;
	
	private String summary2;
	
	private String summary3;
	
	private List<String> skills;
	
	public String getSummary1() {
		return summary1;
	}
	public void setSummary1(String summary1) {
		this.summary1 = summary1;
	}
	public String getSummary2() {
		return summary2;
	}
	public void setSummary2(String summary2) {
		this.summary2 = summary2;
	}
	public String getSummary3() {
		return summary3;
	}
	public void setSummary3(String summary3) {
		this.summary3 = summary3;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

}
