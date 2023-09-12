package com.farhad.example.storedemo.store_app.http.api.orders;

import java.time.Instant;

import lombok.Data;

@Data
public class OrderApiResponse {
	private boolean result;
	private String orderNumber;
	private Instant date;
}
