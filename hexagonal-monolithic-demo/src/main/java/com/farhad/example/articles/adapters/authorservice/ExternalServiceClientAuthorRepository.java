package com.farhad.example.articles.adapters.authorservice;

import org.springframework.stereotype.Component;

import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.AuthorId;
import com.farhad.example.articles.domain.ports.AuthorRepository;

@Component
public class ExternalServiceClientAuthorRepository implements AuthorRepository {

	@Override
	public Author get(AuthorId authorId) {
		AuthorExternalModel authorExternalModel = 
						AuthorExternalModel.builder()
							.withId(Long.valueOf(authorId.getValue()))
							.withFirstName("fname")
							.withLastName("lName")
							.build();

		return authorExternalModel.toDomain();
	}

	
}
