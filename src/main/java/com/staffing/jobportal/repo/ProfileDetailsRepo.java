package com.staffing.jobportal.repo;

import java.util.List;

import org.bson.json.JsonParseException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.staffing.jobportal.models.ProfileDetails;

@Repository
public interface ProfileDetailsRepo extends MongoRepository<ProfileDetails, String> {

	List<ProfileDetails> findAllBySelectedBy(String selectedBy);

	ProfileDetails findByProfileId(String profileId);
	
	List<ProfileDetails> findByPhone(String phone);
	
	long deleteByProfileId(String profileId);

	@Query("{jobCategory: ?0, currentCompany : {$ne : ?1}, overallExp : {$gte : ?2, $lte : ?3}, expectedCTC : {$lte : ?4}, selectedBy  : null}")
	List<ProfileDetails> findAllByJobCat(String jobCategory, String currentCompany, int startExp, int endExp,
			int budget) throws JsonParseException;

	@Query("{jobCategory: ?0, jobProfile : { $all : ?1}, currentCompany : {$ne : ?2}, overallExp : {$gte : ?3, $lte : ?4},  expectedCTC : {$lte : ?5}, selectedBy  : null}")
	List<ProfileDetails> findAllByfilterCriteria(String jobCategory, List<String> jobProfile, String currentCompany,
			int startExp, int endExp, int budget) throws JsonParseException;

	@Query("{jobCategory: ?0, currentCompany : {$ne : ?1}, overallExp : {$gte : ?2, $lte : ?3}, noticePeriod : ?4, expectedCTC : {$lte : ?5}, selectedBy  : null}")
	List<ProfileDetails> findAllByJobCat(String jobCategory, String currentCompany, int startExp, int endExp,
			int noticePeriod, int budget) throws JsonParseException;

	@Query("{jobCategory: ?0, jobProfile : { $all : ?1}, currentCompany : {$ne : ?2}, overallExp : {$gte : ?3, $lte : ?4},  noticePeriod : ?5, expectedCTC : {$lte : ?6}, selectedBy  : null}")
	List<ProfileDetails> findAllByfilterCriteria(String jobCategory, List<String> jobProfile, String currentCompany,
			int startExp, int endExp, int noticePeriod, int budget) throws JsonParseException;
	
	//--------------
	@Query("{jobCategory: ?0, jobProfile : { $all : ?1}, managedBy :  ?2, overallExp : {$gte : ?3, $lte : ?4},  expectedCTC : {$lte : ?5}, selectedBy  : null}")
	List<ProfileDetails> findAllByfilterCriteriaCli(String jobCategory, List<String> jobProfile, String email,
			int startExp, int endExp, int budget) throws JsonParseException;
	
	@Query("{ jobProfile : { $all : ?0}, managedBy :  ?1, overallExp : {$gte : ?2, $lte : ?3},  expectedCTC : {$lte : ?4}, selectedBy  : null}")
	List<ProfileDetails> findAllByfilterCriteriaCli( List<String> jobProfile, String email,
			int startExp, int endExp, int budget) throws JsonParseException;
	
	@Query("{jobCategory: ?0, jobProfile : { $all : ?1}, managedBy :  ?2, overallExp : {$gte : ?3, $lte : ?4},  noticePeriod : ?5, expectedCTC : {$lte : ?6}, selectedBy  : null}")
	List<ProfileDetails> findAllByfilterCriteriaCli(String jobCategory, List<String> jobProfile, String email,
			int startExp, int endExp, int noticePeriod, int budget) throws JsonParseException;
	
	@Query("{jobCategory: ?0, managedBy :  ?1, overallExp : {$gte : ?2, $lte : ?3}, expectedCTC : {$lte : ?4}, selectedBy  : null}")
	List<ProfileDetails> findAllByJobCatCli(String jobCategory, String email, int startExp, int endExp,
			int budget) throws JsonParseException;

	@Query("{jobCategory: ?0, managedBy :  ?1, overallExp : {$gte : ?2, $lte : ?3}, noticePeriod : ?4, expectedCTC : {$lte : ?5}, selectedBy  : null}")
	List<ProfileDetails> findAllByJobCatCli(String jobCategory, String email, int startExp, int endExp,
			int noticePeriod, int budget) throws JsonParseException;

	@Query("{managedBy :  ?0, overallExp : {$gte : ?1, $lte : ?2}, expectedCTC : {$lte : ?3}, selectedBy  : null}")
	List<ProfileDetails> findAllByJobCatCli(String email, int startExp, int endExp,
			int budget) throws JsonParseException;
	
}
