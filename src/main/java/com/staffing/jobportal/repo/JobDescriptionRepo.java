package com.staffing.jobportal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.JobDescription;

@Repository
public interface JobDescriptionRepo extends MongoRepository<JobDescription, String>{
	
	@Query("{jobCategory: ?0, jobCategoryCode : ?1}")
	JobDescription findByCategory(String jobCategory, String jobCategoryCode);
}
