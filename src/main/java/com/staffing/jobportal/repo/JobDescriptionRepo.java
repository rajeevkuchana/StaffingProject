package com.staffing.jobportal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.JobDescription;

@Repository
public interface JobDescriptionRepo extends MongoRepository<JobDescription, String>{
	

}
