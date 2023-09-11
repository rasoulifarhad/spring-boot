package com.farhad.example.dddorderdemo.bookstore.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class User {
	private final UserId id;
	private UserName name;
}
