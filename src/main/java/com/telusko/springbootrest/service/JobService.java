package com.telusko.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.repo.JobRepo;


@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	
	
	//method to return all JobPosts
//	public List<JobPost> getAllJobs() {
//		return repo.getAllJobs();
//	}

	public List<JobPost> getAllJobs(){
		return repo.findAll();
	}

	
	
	
	

	// ***************************************************************************


	
	
	
	// method to add a jobPost
	public void addJob(JobPost jobPost) {
		 repo.save(jobPost);
	
	}





	public JobPost getJob(int postId) {
		
		return repo.findById(postId).orElse(new JobPost());
	}





	public void updateJob(JobPost jobPost) {
	repo.save(jobPost);
		
	}





	public void deleteJob(int postId) {
		repo.deleteById(postId);
		
	}

	
}
