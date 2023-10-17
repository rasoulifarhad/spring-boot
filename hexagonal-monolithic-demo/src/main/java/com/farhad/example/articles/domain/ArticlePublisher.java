package com.farhad.example.articles.domain;

import java.util.List;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.ports.ArticleMessageSender;
import com.farhad.example.articles.domain.ports.AuthorNotifier;
import com.farhad.example.articles.domain.ports.SocialMediaPublisher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticlePublisher {
	
	private final ArticleMessageSender articleMessageSender;
	private final List<SocialMediaPublisher> socialMediaPublishers;
	private final List<AuthorNotifier> authorNotifiers;

	public void publishCreationOf(Article article){
		articleMessageSender.sendMessageForCreated(article);
		socialMediaPublishers.forEach(s -> s.publish(article));
		authorNotifiers.forEach(a -> a.notifyAboutCreationOf(article));

	}

	public void publishRetrievalOf(Article article) {
        articleMessageSender.sendMessageForCreated(article);
	}

}
