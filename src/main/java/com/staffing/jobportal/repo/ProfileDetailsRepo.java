package com.staffing.jobportal.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.ProfileDetails;

@Repository
public interface ProfileDetailsRepo extends MongoRepository<ProfileDetails, String>{
	
	List<ProfileDetails> findAllBySelectedBy(String selectedBy);
	
	ProfileDetails findByProfileId(String profileId);
	
	long deleteByProfileId(String profileId);
	  
	//boolean updateByProfileId(String profileId, ProfileDetails profileDetails);
	
	
}

