package com.farhad.example.articles.adapters.articledb;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.farhad.example.articles.domain.model.Article;
import com.farhad.example.articles.domain.model.ArticleId;
import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.AuthorId;
import com.farhad.example.articles.domain.model.Content;
import com.farhad.example.articles.domain.model.PersonName;
import com.farhad.example.articles.domain.model.Title;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "articles")
@ToString(of = "title")
@EqualsAndHashCode(of = "id")
@Getter
@RequiredArgsConstructor
@Builder(setterPrefix = "with")
public class ArticleDatabaseModel {
	
	@Id
	private final UUID id;

	private final String title;
    private final String content;

	@Version
    private final long version;
	
    private final Instant createdAt;
    private final String authorId;
    private final String authorName;

	public Article toDomain() {
		return Article.builder()
					.withArticleId(ArticleId.of(id.toString()))
					.withAuthor(
						Author.builder()
							.withAuthorId(AuthorId.of(authorId))
							.withPersonName(PersonName.of(authorName))
							.build()
					)
					.withTitle(Title.of(title))
					.withContent(Content.of(content))
					.build();
	}

	public static ArticleDatabaseModel of(Author author, Title title, Content content) {
		return ArticleDatabaseModel.builder()
					.withId(UUID.randomUUID())
					.withVersion(0)
					.withCreatedAt(Instant.now())
					.withAuthorId(author.getAuthorId().getValue())
					.withAuthorName(author.getName())
					.withTitle(title.getValue())
					.withContent(content.getValue())
					.build();
	}

	public static ArticleDatabaseModel of(Article article) {
		return of(article.getAuthor(), article.getTitle(), article.getContent());
	}
}
