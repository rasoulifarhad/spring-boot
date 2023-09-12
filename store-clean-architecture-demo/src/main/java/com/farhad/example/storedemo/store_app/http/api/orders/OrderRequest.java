package com.farhad.example.storedemo.store_app.http.api.orders;

import java.util.Map;

import lombok.Data;

@Data
public class OrderRequest {
	private Map<String, Integer> items;
}
