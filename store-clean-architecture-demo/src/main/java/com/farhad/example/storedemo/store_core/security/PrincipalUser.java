package com.farhad.example.storedemo.store_core.security;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class PrincipalUser {
	private final String name;
	private final String email;
}
