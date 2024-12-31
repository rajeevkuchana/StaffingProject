package com.staffing.jobportal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{
	
	User findByUsername(String username);
	
	@Query("{email: ?0}")
	User findByEmail(String email,String password);
	
	@Query("{'email': { $regex: ?0, $options: 'i' }}")
    User findByEmail(String email);
	
	void deleteById(String id);

}
