package com.farhad.example.dddorderdemo.bookstore.domain.user;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class UserName {
	private final String name;
}
