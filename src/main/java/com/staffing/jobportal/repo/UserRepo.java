package com.staffing.jobportal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	void deleteById(String id);

}
