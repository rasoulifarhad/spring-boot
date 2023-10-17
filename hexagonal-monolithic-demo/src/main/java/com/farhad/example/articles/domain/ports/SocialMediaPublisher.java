package com.farhad.example.articles.domain.ports;

import com.farhad.example.articles.domain.model.Article;

public interface SocialMediaPublisher {

	void publish(Article article);
	
}
