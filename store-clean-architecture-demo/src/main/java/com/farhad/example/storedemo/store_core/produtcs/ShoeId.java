package com.farhad.example.storedemo.store_core.produtcs;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ShoeId {
	private final String value;

	public static ShoeId from(String rawValue) {
		return new ShoeId(UUID.fromString(rawValue).toString());
	}
}
