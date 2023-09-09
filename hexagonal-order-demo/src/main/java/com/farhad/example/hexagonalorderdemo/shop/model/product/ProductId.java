package com.farhad.example.hexagonalorderdemo.shop.model.product;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class ProductId {

	private static final String ALPHABET = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
	private static final int LENGTH_OF_NEW_PRODUCT_IDS = 8;
	private final String value;

	public ProductId(final String value) {
		Objects.requireNonNull(value, "value must not be null");
		if(value.trim().isEmpty()) {
			throw new IllegalArgumentException("value must not be empty");
		}
		this.value = value.trim();
	}

	public static ProductId randomProductId() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		char[] chars = new char [LENGTH_OF_NEW_PRODUCT_IDS];
		for (int i = 0; i < LENGTH_OF_NEW_PRODUCT_IDS; i++) {
			chars[i] = ALPHABET.charAt(random.nextInt(ALPHABET.length()));
		} 
		return new ProductId(new String(chars));
	}
}
