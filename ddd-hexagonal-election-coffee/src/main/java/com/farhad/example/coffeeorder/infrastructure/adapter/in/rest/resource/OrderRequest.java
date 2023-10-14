package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.shared.Location;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class OrderRequest {
	
	private Location location;

	private List<LineItemRequest> items;

	public Order toDomain() {
		return new Order(location, items.stream().map(LineItemRequest::toDomain).collect(toList()));
	}
}
