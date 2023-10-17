package com.farhad.example.articles.adapters.socialmedia;

import com.farhad.example.articles.domain.model.Article;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class ArticleTwitterModel {

    private static final String TWEET = "Check out the new article >>%s<< by %s";
    
	private final String twitterAccountId;
    private final String tweet;	

	public static ArticleTwitterModel of(Article article) {
		return new ArticleTwitterModel(
			article.getAuthor().getName(), 
			String.format(TWEET, article.getTitle().getValue(), article.getAuthor().getName()));
	}
	
}
