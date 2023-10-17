package com.farhad.example.articles.adapters.articledb;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.model.ArticleId;
import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.Content;
import com.farhad.example.articles.domain.model.Title;
import com.farhad.example.articles.domain.ports.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DbArticleRepository implements ArticleRepository  {

	private final ArticleJpaRepository articleJpaRepository;

	@Override
	public Article save(Author author, Title title, Content content) {
		
		return articleJpaRepository.save(
					ArticleDatabaseModel.of(author, title, content)).toDomain();
	}

	@Override
	public Article findById(ArticleId id) {

		return articleJpaRepository.findById(UUID.fromString(id.getValue()))
					.map(ArticleDatabaseModel::toDomain)
					.orElse(null);
	}
	
}
