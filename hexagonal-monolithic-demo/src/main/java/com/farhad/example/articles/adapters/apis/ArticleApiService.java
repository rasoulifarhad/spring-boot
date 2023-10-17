package com.farhad.example.articles.adapters.apis;

import org.springframework.stereotype.Component;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.model.Article.ArticleId;
import com.farhad.example.articles.domain.ports.ArticleService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ArticleApiService {

	private final ArticleService articleService;
	ArticleIdResponse create(ArticleRequest articleRequest) {
		final ArticleId articleId = articleService.create(
			articleRequest.getAuthorId(),
			articleRequest.getTitle(),
			articleRequest.getContent());
		return ArticleIdResponse.of(articleId);
	}

	ArticleResponse get(String articleId) {
		final Article article = articleService.get(ArticleId.of(articleId));
		return ArticleResponse.of(article);
	}
	
}
