package com.farhad.example.dddlibrary.library.domain.repository;

import com.farhad.example.dddlibrary.library.domain.Book;

public interface BookRepository {

	Book findById(int bookId);

	void update(Book book);
	
}
