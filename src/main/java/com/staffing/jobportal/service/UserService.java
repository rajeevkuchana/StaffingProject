package com.staffing.jobportal.service;

import java.util.List;

import com.staffing.jobportal.models.User;

public interface UserService {
	    
		public String addUser(User user) ;
	    
	    public boolean deleteUser(String userId) ;
	    
	    public User verifyUser(String emailId);
	    
	    public List<User> getAllUsers();
}
