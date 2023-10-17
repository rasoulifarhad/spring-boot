package com.farhad.example.articles.adapters.socialmedia;

import org.springframework.stereotype.Component;

@Component
public class TwitterClient {

	public void tweet(ArticleTwitterModel articleTweet) {
		System.out.println(articleTweet);
	}
	

}
