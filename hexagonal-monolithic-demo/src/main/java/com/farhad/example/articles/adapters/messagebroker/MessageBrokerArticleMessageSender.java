package com.farhad.example.articles.adapters.messagebroker;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.ports.ArticleMessageSender;

public class MessageBrokerArticleMessageSender implements ArticleMessageSender{

	@Override
	public void sendMessageForCreated(Article article) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'sendMessageForCreated'");
	}
	
}
