package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.List;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.shared.Location;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class OrderResponse {
	Location location;
	List<LineItemResponse> items;
	BigDecimal cost;
	public static OrderResponse fromDomain(Order order) {
		return new OrderResponse(
			order.getLocation(), 
			order.getItems().stream().map(LineItemResponse::fromDomain).collect(toList()), 
			order.getCost());
	} 
	
}
