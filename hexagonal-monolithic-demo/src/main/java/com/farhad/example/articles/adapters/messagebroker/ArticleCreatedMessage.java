package com.farhad.example.articles.adapters.messagebroker;

import java.time.Instant;

import com.farhad.example.articles.domain.model.Article;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class ArticleCreatedMessage {
	
	private final Article article;
	private final Instant sendAt;

	public static ArticleCreatedMessage of(Article article) {
		return new ArticleCreatedMessage(article, Instant.now()); 
	}
}
