package com.farhad.example.articles.adapters.notifications;

import org.springframework.stereotype.Component;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.ports.AuthorNotifier;

@Component
public class AuthorMailNotifier implements AuthorNotifier {

	@Override
	public void notifyAboutCreationOf(Article article) {
		System.out.println(ArticleMailModel.of(article));
	}
	
}
