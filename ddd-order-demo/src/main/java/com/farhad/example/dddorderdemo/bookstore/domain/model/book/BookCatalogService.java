package com.farhad.example.dddorderdemo.bookstore.domain.model.book;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookCatalogService {
	
	private final BookRepository bookRepository;

	public Book findMostPopularBook() {
		return null;
	}
}
