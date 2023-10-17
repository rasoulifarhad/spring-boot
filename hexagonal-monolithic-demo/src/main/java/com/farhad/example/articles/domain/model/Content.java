package com.farhad.example.articles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Content {

	private String value;

	public static Content of(String value) {
		return new Content(value);
	}

}
