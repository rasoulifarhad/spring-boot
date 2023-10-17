package com.farhad.example.articles.adapters.notifications;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.ports.AuthorNotifier;

public class AuthorSmsNotifier implements AuthorNotifier{

	@Override
	public Object notifyAboutCreationOf(Article article) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'notifyAboutCreationOf'");
	}
	
}
