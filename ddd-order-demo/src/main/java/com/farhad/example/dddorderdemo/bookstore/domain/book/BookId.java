package com.farhad.example.dddorderdemo.bookstore.domain.book;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class BookId {
	private final String id; 
}
