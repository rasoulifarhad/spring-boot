package com.farhad.example.articles.domain.ports;

import com.farhad.example.articles.domain.model.Author;
import com.farhad.example.articles.domain.model.AuthorId;

public interface AuthorRepository {

	Author get(AuthorId authorId);
	
}
