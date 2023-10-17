package com.farhad.example.articles.domain.ports;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.model.ArticleId;
import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.Content;
import com.farhad.example.articles.domain.model.Title;

public interface ArticleRepository {

	Article save(Author author, Title title, Content content);

	Article findById(ArticleId id);
	
}
