package com.farhad.example.articles.domain.ports;

import com.farhad.example.articles.domain.ArticlePublisher;
import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.model.ArticleId;
import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.AuthorId;
import com.farhad.example.articles.domain.model.Content;
import com.farhad.example.articles.domain.model.Title;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleService {

	private final ArticleRepository articleRepository;
	private final AuthorRepository authorRepository;
	private final ArticlePublisher articlePublisher;

	public ArticleId create(AuthorId authorId, Title title, Content content) {
		Author author = authorRepository.get(authorId);
		// Article article = Article.builder().title(title).content(content).author(author).build();
		// article = articleRepository.save(article);
		Article article = articleRepository.save(author, title, content);
		article.validateEligibilityForPublication();
		articlePublisher.publishCreationOf(article);
		return article.getArticleId();
	}

	public Article get(ArticleId id) {
		Article article = articleRepository.findById(id);
		articlePublisher.publishRetrievalOf(article);
		return article;
	}
	
}
