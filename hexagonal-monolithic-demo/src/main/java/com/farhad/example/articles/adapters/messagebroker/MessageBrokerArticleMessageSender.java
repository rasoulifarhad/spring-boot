package com.farhad.example.articles.adapters.messagebroker;

import org.springframework.stereotype.Component;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.ports.ArticleMessageSender;

@Component
public class MessageBrokerArticleMessageSender implements ArticleMessageSender{

	@Override
	public void sendMessageForCreated(Article article) {
		System.out.println(ArticleCreatedMessage.of(article));
	}

	@Override
	public void sendMessageForRetrieved(Article article) {
		System.out.println(ArticleRetrievedMessage.of(article));
	}
	
}
