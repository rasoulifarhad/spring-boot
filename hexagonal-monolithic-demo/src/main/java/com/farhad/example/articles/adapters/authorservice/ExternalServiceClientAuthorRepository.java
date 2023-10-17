package com.farhad.example.articles.adapters.authorservice;

import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.AuthorId;
import com.farhad.example.articles.domain.ports.AuthorRepository;

public class ExternalServiceClientAuthorRepository implements AuthorRepository {

	@Override
	public Author get(AuthorId authorId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}
	
}
