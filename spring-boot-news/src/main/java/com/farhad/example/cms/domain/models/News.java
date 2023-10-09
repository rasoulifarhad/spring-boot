package com.farhad.example.cms.domain.models;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class News {
	
	String id;

	String title;
  
	String content;
  
	User author;

	Set<User> mandatoryReviewers = new HashSet<>();
	Set<Review> reviewers = new HashSet<>();
	Set<Category> categories = new HashSet<>();
	Set<Tag> tags = new HashSet<>();

	public Boolean revised() {
		return mandatoryReviewers.stream()
				.allMatch(reviewer -> 
					reviewers.stream()
							.anyMatch(review -> 
								reviewer.getId().equals(review.getUserId()) && 
								"approved".equals(review.getStatus()) ));
	}

	public Review review(String userIs, String status) {
		final Review review = new Review(userIs, status);
		reviewers.add(review);
		return review;
	}

}
