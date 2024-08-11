package com.staffing.jobportal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.JobProfiles;

@Repository
public interface JobProfileRepo extends MongoRepository<JobProfiles, String>{
	

}
