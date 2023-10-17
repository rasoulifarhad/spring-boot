package com.farhad.example.articles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ArticleId {

	private String value;

	public static ArticleId of(String value) {
		return new ArticleId(value);
		// return new ArticleId(UUID.fromString(value).toString());
	}

	// public static ArticleId newId() {
	// 	return new ArticleId(UUID.randomUUID().toString());
	// }


}
