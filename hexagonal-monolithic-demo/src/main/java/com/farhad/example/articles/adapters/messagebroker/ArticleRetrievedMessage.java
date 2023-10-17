package com.farhad.example.articles.adapters.messagebroker;

import java.time.Instant;

import com.farhad.example.articles.domain.model.Article;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ArticleRetrievedMessage {

	private final Article article;
	private final Instant sendAt;

	public static ArticleRetrievedMessage of(Article article) {
		return new ArticleRetrievedMessage(article, Instant.now());
	}

}
