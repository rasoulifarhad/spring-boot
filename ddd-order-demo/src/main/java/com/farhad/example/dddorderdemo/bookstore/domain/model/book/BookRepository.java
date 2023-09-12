package com.farhad.example.dddorderdemo.bookstore.domain.model.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookId> {
	List<Book> findByTitle(BookTitle title);
}
