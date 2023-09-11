package com.farhad.example.dddorderdemo.bookstore.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class UserId {
	private final String id;	
}
