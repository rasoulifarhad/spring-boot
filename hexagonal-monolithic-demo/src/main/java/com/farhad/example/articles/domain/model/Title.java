package com.farhad.example.articles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Title {

	private String value;

	public static Title of(String value) {
		return new Title(value);
	}
}
