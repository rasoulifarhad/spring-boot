package com.farhad.example.articles.adapters.socialmedia;

import org.springframework.stereotype.Component;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.ports.SocialMediaPublisher;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TwitterArticlePublisher implements SocialMediaPublisher{

	private final TwitterClient twitterClient;

	@Override
	public void publish(Article article) {
		ArticleTwitterModel articleTweet = ArticleTwitterModel.of(article);
		twitterClient.tweet(articleTweet);
	}
	
}
