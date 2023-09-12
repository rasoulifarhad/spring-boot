package com.farhad.example.storedemo.store_core.variants;

import java.util.Objects;

public class InventoryItem {
	private final String serialNumber;

	public InventoryItem(String serialNumber) {
		Objects.requireNonNull(serialNumber, "serial number must not be null");
		assert ((!serialNumber.isEmpty()) && (serialNumber.length() > 3));

		this.serialNumber = serialNumber;
	}

	
}
