package com.farhad.example.storedemo.store_core.produtcs;

import com.farhad.example.storedemo.store_core.money.Money;

import lombok.Value;

@Value
public class ShoeLookupQuery {
	private String byName;
	private Money byPrice;

	public boolean isEmpty() {
		return byName == null && byPrice == null;
	}

}
