package com.farhad.example.storedemo.store_core.variants;

import java.util.Optional;
import java.util.stream.Stream;

public enum VariantSize {
	US_10("US_10"),
	US_10_5("US_10_5"),
	US_11("US_11"),
	US_11_5("US_11_5");

	private final String code;

	private VariantSize(final String code) {
		this.code = code;
	}

	public static Optional<VariantSize> lookup(final String code) {
		return Stream.of(VariantSize.values())
					.filter(t -> t.code.equals(code))
					.findAny();
	}

}
