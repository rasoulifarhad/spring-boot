package com.farhad.example.storedemo.store_app.http.api.orders;

import java.util.Map;

import com.farhad.example.storedemo.store_core.money.Money;

import lombok.Data;

@Data
public class PreviousOrder {
	private String id;
	private String time;
	private Money price;
	private Map<String, Integer> items;
}
