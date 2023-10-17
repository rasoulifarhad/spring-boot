package com.farhad.example.articles.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "articleId")
@ToString
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Author {

	private AuthorId authorId;
	private PersonName personName;

	public String getName() {
		return personName.getName();
	}

}
