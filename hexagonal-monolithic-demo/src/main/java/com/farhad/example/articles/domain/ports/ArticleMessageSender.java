package com.farhad.example.articles.domain.ports;

import com.farhad.example.articles.domain.model.Article;

public interface ArticleMessageSender {

	void sendMessageForCreated(Article article);

}
