package com.staffing.jobportal.repo;


import java.util.List;

import org.bson.json.JsonParseException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.ProfileDetails;

@Repository
public interface ProfileDetailsRepo extends MongoRepository<ProfileDetails, String>{
	
	List<ProfileDetails> findAllBySelectedBy(String selectedBy);
	
	ProfileDetails findByProfileId(String profileId);
	
	long deleteByProfileId(String profileId);
	  
	@Query("{jobCategory: ?0, currentCompany : {$ne : ?1}, selectedBy  : null}}")
	List<ProfileDetails> findAllByJobCat(String jobCategory,String currentCompany) throws JsonParseException;
	
	@Query("{jobCategory: ?0, jobProfile : { $in : ?1}, currentCompany : {$ne : ?1}, selectedBy  : null}}")
	List<ProfileDetails> findAllByfilterCriteria(String jobCategory, List<String> jobProfile, String currentCompany) throws JsonParseException;
	
	
	
}

