package com.farhad.example.articles.adapters.apis;

import com.farhad.example.articles.domain.model.ArticleId;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class ArticleIdResponse {
	
    private final String id;

	static ArticleIdResponse of(ArticleId articleId) {
		return new ArticleIdResponse(
			articleId.getValue());
	}
}
