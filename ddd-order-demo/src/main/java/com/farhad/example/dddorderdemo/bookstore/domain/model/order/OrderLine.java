package com.farhad.example.dddorderdemo.bookstore.domain.model.order;

import com.farhad.example.dddorderdemo.bookstore.domain.model.book.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class OrderLine {
	private OrderLineId id;
	private final Book book;
	private final int quantity;
}
