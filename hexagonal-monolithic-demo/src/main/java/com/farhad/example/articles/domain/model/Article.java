package com.farhad.example.articles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Getter
@EqualsAndHashCode(of = "articleId")
@ToString
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article {
	
	private ArticleId articleId;
	private Title title;
	private Content content;
	private Author author;

	@AllArgsConstructor
	@Value
	public static class ArticleId {

		private String value;

		public static ArticleId of(String value) {
			return new ArticleId(value);
		}
	}

	@AllArgsConstructor
	@Value
	public static class Title {

		private String value;
	}
	@AllArgsConstructor
	@Value
	public static class Content {

		private String value;
	}

}
