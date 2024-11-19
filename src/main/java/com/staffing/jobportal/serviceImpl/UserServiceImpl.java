package com.staffing.jobportal.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffing.jobportal.models.User;
import com.staffing.jobportal.repo.UserRepo;
import com.staffing.jobportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepository;

	public String addUser(User user) {
		
		String createStatus = "";
		User userAlready = null;
		try {
			userAlready = userRepository.findByEmail(user.getEmail());
			if(null == userAlready) {
				user.setId(UUID.randomUUID() + "");
				userRepository.save(user);
				createStatus = "Created";
			}else {
				createStatus = "User Already Exist";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return createStatus;

	}

	public boolean deleteUser(String userId) {
		
		boolean deleteStatus = false;
		try {
			userRepository.deleteById(userId);
			deleteStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteStatus;

	}

	public User verifyUser(String emailId) {
		
		User user = null;
		try {
			user = userRepository.findByEmail(emailId);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	@Override
	public List<User> getAllUsers() {
		

		List<User> userList = new ArrayList<User>();
		try {
			userList = userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	// Add other service methods as needed
}
