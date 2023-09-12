package com.farhad.example.storedemo.store_core.orders;

import java.time.Instant;

import com.farhad.example.storedemo.store_core.money.Money;

import lombok.Value;

public interface OrderResult {

	@Value
	public static class OrderFailure implements OrderResult {
		private final String reason;
	}
	
	@Value
	public static class OrderSuccess implements OrderResult {
		private final OrderId orderId;
		private final Money totalCost;
		private final Instant time;
	}
}

