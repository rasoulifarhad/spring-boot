package com.farhad.example.storedemo.store_app.http.api.orders;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

import com.farhad.example.storedemo.store_core.orders.Order;
import com.farhad.example.storedemo.store_core.orders.OrderLineItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PreviousCustomerOrderResponse {
	private List<PreviousOrder> orders;

	public static PreviousCustomerOrderResponse from(List<Order> orders) {
		return new PreviousCustomerOrderResponse(
			orders.stream()
						.map(order -> 
							new PreviousOrder(
								order.getId().getValue(),
								order.getTime().toString(),
								order.getPrice(),
								items(order.getItems())
							)
						)
						.collect(toList())
						);
	}

	private static Map<String, Integer> items(List<OrderLineItem> lineItems) {
		return lineItems
					.stream()
					.collect(
						toMap(	
							lineItem -> lineItem.getSku().getValue(), 
							lineItem -> lineItem.getInventoryItems().size()));
	}
}
