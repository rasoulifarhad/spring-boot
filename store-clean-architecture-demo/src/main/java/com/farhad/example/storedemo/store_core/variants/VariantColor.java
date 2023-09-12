package com.farhad.example.storedemo.store_core.variants;

import java.util.Optional;
import java.util.stream.Stream;

public enum VariantColor {
	WHITE("white"),
	GREEN("green"),
	BLACK("black"),
	BLUE("blue"),
	RED("red");


	private final String code;

	private VariantColor(final String code) {
		this.code = code;
	}

	public static Optional<VariantColor> lookup(String code) {
		return Stream.of( VariantColor.values())
					.filter(t -> t.code.equals(code)) 
					.findAny();
	}

}
