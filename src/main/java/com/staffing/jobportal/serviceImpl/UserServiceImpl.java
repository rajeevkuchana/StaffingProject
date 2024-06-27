package com.staffing.jobportal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.staffing.jobportal.models.User;
import com.staffing.jobportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    private List<User> users = new ArrayList<>();
    
    public User addUser(User user) {
        // Perform validation if needed
        
        // Assign an ID (you might want to use a better ID generation strategy)
        user.setId((long) (users.size() + 1));
        
        // Save user to list (or database if using a repository)
        users.add(user);
        
        return user;
    }
    
    public void deleteUser(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }
    
    public User verifyUser(String username) {
        // Dummy verification, replace with actual logic
    	
    	  Optional<User> userOptional = users.stream()
                  .filter(user -> user.getUsername().equals(username))
                  .findFirst();
    	
        return userOptional.get();
    }

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return users;
	}
    
    // Add other service methods as needed
}
