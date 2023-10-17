package com.farhad.example.articles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * External dependencies (outbound ports) of Article domain stand for:
 * 
 *  - persisting and retrieving an article via ArticleRepository port,
 *  - retrieving an author via AuthorRepository port,
 *  - notifying the author about the successful publication of an article via AuthorNotifier port,
 *  - posting information about an article to social media via SocialMediaPublisher port,
 *  - sending a message, triggered either by article creation or retrieval, to a message broker via ArticleMessageSender port.
 *  
 */

@Getter
@EqualsAndHashCode(of = "articleId")
@ToString
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "with")
@NoArgsConstructor
public class Article {
	
	private ArticleId articleId;
	private Title title;
	private Content content;
	private Author author;


	public void validateEligibilityForPublication() {

	}

}
