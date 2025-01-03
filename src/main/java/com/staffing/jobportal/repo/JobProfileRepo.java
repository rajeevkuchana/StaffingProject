package com.staffing.jobportal.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.JobProfiles;

@Repository
public interface JobProfileRepo extends MongoRepository<JobProfiles, String>{
	
	@Query("{jobCategory: ?0}")
	List<JobProfiles> findByJobCategory(String jobCategory);
	
	@Query("{jobCategory: ?0, categoryCode: ?1}")
	JobProfiles findByCategoryCode(String jobCategory, String categoryCode);
	
}
