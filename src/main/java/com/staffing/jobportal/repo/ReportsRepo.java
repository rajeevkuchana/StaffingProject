package com.staffing.jobportal.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.ReportData;

@Repository
public interface ReportsRepo extends MongoRepository<ReportData, String>{
	
	
}
