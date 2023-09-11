package com.farhad.example.dddorderdemo.bookstore.domain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
	private final BookId id;
	private BookTitle title;
	private BookDescription description;
}
