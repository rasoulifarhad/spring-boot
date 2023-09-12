package com.farhad.example.storedemo.store_app.http.api.orders;

import java.util.List;

import lombok.Data;

@Data
public class PreviousCustomerOrderResponse {
	private List<PreviousOrder> orders;
}
