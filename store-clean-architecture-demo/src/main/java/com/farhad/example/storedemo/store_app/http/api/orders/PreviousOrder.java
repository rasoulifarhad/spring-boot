package com.farhad.example.storedemo.store_app.http.api.orders;

import java.util.Map;

import com.farhad.example.storedemo.store_core.money.Money;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class PreviousOrder {
	private String id;
	private String time;
	private Money price;
	private Map<String, Integer> items;
}
