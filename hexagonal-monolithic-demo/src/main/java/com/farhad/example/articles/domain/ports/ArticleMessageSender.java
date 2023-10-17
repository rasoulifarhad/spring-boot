package com.farhad.example.articles.domain.ports;

import com.farhad.example.articles.domain.model.Article;

public interface ArticleMessageSender {

	public void sendMessageForCreated(final Article article);
	public void sendMessageForRetrieved(final Article article);

}
