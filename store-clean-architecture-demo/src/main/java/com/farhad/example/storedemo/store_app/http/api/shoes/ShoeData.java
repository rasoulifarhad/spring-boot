package com.farhad.example.storedemo.store_app.http.api.shoes;

import com.farhad.example.storedemo.store_core.money.Money;

import lombok.Data;

@Data
public class ShoeData {
	private String id;
	private String name;
	private String description;
	private Money displayPrice;
}
