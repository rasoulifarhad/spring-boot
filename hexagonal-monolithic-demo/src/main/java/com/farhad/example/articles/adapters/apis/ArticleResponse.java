package com.farhad.example.articles.adapters.apis;

import com.farhad.example.articles.domain.model.Article;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class ArticleResponse {
    private final String id;
    private final String title;
    private final String content;
    private final String authorName;	

	static ArticleResponse of(Article article) {
		return new ArticleResponse(
			article.getArticleId().getValue(), 
			article.getTitle().getValue(), 
			article.getContent().getValue(), 
			article.getAuthor().getName());
	}

}
