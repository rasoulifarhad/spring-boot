package com.farhad.example.articles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class AuthorId {

	private String value;

	public static AuthorId of(String value) {
		return new AuthorId(value);
	}
}
