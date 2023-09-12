package com.farhad.example.storedemo.store_core.variants;

import java.util.Objects;

import lombok.Value;

// Stock Keeping Unit
//
// A Stock Keeping Unit (SKU) is a unique identifier for a product, typically assigned by a retailer or manufacturer. It is 
// used to track inventory and is typically associated with a product's barcode. An example of a SKU is XYZ12345. This would 
// be the unique identifier for a specific product, such as a T-shirt.

@Value	
public class Sku {
	private final String value;

	public Sku(String value) {
		Objects.requireNonNull(value, "value must not be null");
		assert (!value.isEmpty());
		assert (value.length() > 6 && value.length() < 127);
		this.value = value;
	}

	
}
