package com.farhad.example.cms.domain.models;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class NewsTest {

	@Test
	public void shouldBrREvised() {
		News news = new News();
		User reviewer = new User();
		reviewer.setId("1234");
		news.setMandatoryReviewers(Stream.of(reviewer).collect(toSet()));
		news.review("1234", "approved");
		assertTrue(news.revised());
	}

	@Test
	public void wrongUserReviewedAndShouldBeNotRevised() {

		News news = new News();
		User reviewer = new User();
		reviewer.setId("5678");
		news.setMandatoryReviewers(Stream.of(reviewer).collect(toSet()));
		news.review("1234", "approved");
		assertFalse(news.revised());
	}

	@Test
	public void userNotApprovedAndShouldBeNotRevised() {
		News news = new News();
		User reviewer = new User();
		reviewer.setId("1234");
		news.setMandatoryReviewers(Stream.of(reviewer).collect(toSet()));
		news.review("1234", "unapproved");
		assertFalse(news.revised());
	}
}
