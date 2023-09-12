package com.farhad.example.storedemo.store_core.orders;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderId {
	private final String value;

	public static OrderId from(String rawVlue) {
		return new OrderId(UUID.fromString(rawVlue).toString());
	}

	public static OrderId newId() {
		return new OrderId(UUID.randomUUID().toString());
	}
}
