package com.farhad.example.articles.adapters.authorservice;

import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.AuthorId;
import com.farhad.example.articles.domain.model.PersonName;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(setterPrefix = "with")
@ToString(of = "fullName")
@Getter
public class AuthorExternalModel {
	
	private final Long id;
	private final String firstName;
	private final String lastName;

	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
	}

	public Author toDomain() {
		return Author.builder()
				.withAuthorId(AuthorId.of(String.valueOf(id)))
				.withPersonName(PersonName.of(getFullName()))
				.build();
	}
}
