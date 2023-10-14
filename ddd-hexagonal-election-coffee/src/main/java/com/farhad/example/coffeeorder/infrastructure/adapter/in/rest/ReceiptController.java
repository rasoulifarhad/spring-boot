package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.coffeeorder.application.in.OrderingCoffee;
import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.payment.Receipt;
import com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource.OrderResponse;
import com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource.ReceiptResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReceiptController {
	

	private final OrderingCoffee orderingCoffee;

    @GetMapping("/receipt/{id}")
    ResponseEntity<ReceiptResponse> readReceipt(@PathVariable UUID id) {
        Receipt receipt = orderingCoffee.readReceipt(id);
        return ResponseEntity.ok(ReceiptResponse.fromDomain(receipt));
    }

    @DeleteMapping("/receipt/{id}")
    ResponseEntity<OrderResponse> completeOrder(@PathVariable UUID id) {
        Order order = orderingCoffee.takeOrder(id);
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }	
}
