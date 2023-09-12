package com.farhad.example.dddorderdemo.bookstore.domain.model.user;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class UserId {
	private final String id;	
}
