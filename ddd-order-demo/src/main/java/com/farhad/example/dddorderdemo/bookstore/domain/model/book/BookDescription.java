package com.farhad.example.dddorderdemo.bookstore.domain.model.book;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class BookDescription {
	private final String value;
}
