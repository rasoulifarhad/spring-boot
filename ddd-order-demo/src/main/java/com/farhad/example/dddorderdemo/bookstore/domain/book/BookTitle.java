package com.farhad.example.dddorderdemo.bookstore.domain.book;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class BookTitle {
	private final String value;
}
