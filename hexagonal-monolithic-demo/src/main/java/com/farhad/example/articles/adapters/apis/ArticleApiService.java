package com.farhad.example.articles.adapters.apis;

import org.springframework.stereotype.Component;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.model.ArticleId;
import com.farhad.example.articles.domain.model.AuthorId;
import com.farhad.example.articles.domain.model.Content;
import com.farhad.example.articles.domain.model.Title;
import com.farhad.example.articles.domain.ports.ArticleService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ArticleApiService {

	private final ArticleService articleService;
	ArticleIdResponse create(ArticleRequest articleRequest) {
		final ArticleId articleId = articleService.create(
					AuthorId.of(articleRequest.getAuthorId()),
					new Title(articleRequest.getTitle()),
					new Content(articleRequest.getContent()));
		return ArticleIdResponse.of(articleId);
	}

	ArticleResponse get(String articleId) {
		final Article article = articleService.get(ArticleId.of(articleId));
		return ArticleResponse.of(article);
	}
	
}
