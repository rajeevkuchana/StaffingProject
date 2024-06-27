package com.staffing.jobportal.service;

import java.util.List;

import com.staffing.jobportal.models.User;

public interface UserService {
	    
		public User addUser(User user) ;
	    
	    public void deleteUser(Long userId) ;
	    
	    public User verifyUser(String username);
	    
	    public List<User> getAllUsers();
}
