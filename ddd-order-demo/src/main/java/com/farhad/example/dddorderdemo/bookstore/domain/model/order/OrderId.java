package com.farhad.example.dddorderdemo.bookstore.domain.model.order;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class OrderId {
	private final String value;
}
