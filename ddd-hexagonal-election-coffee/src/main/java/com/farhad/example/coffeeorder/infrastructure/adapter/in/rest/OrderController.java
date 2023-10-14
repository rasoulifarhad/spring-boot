package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest;

import java.net.URI;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.farhad.example.coffeeorder.application.in.OrderingCoffee;
import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource.OrderRequest;
import com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource.OrderResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderingCoffee orderingCoffee;

	@PostMapping("/order")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request, UriComponentsBuilder uriComponentsBuilder) {
		Order order = orderingCoffee.placeOrder(request.toDomain());
		URI location = uriComponentsBuilder.path("/order/{id}")
				.buildAndExpand(order.getId())
				.toUri();
		return ResponseEntity.created(location).body(OrderResponse.fromDomain(order));
	}

 	@PostMapping("/order/{id}")
    ResponseEntity<OrderResponse> updateOrder(@PathVariable UUID id, @RequestBody OrderRequest request) {
        Order order = orderingCoffee.updateOrder(id, request.toDomain());
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }

    @DeleteMapping("/order/{id}")
    ResponseEntity<Void> cancelOrder(@PathVariable UUID id) {
        orderingCoffee.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }	
}
