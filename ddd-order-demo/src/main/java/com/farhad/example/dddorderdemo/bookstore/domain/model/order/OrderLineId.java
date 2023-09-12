package com.farhad.example.dddorderdemo.bookstore.domain.model.order;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class OrderLineId {
	
	private final String id;
}
