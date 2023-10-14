package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest;

import java.time.Month;
import java.time.Year;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.coffeeorder.application.in.OrderingCoffee;
import com.farhad.example.coffeeorder.application.payment.CreditCard;
import com.farhad.example.coffeeorder.application.payment.Payment;
import com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource.PaymentRequest;
import com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource.PaymentResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PaymentController {
	
	private final OrderingCoffee orderingCoffee;

    @PutMapping("/payment/{id}")
    ResponseEntity<PaymentResponse> payOrder(@PathVariable UUID id, @Valid @RequestBody PaymentRequest request) {
        Payment payment = orderingCoffee.payOrder(id,
                new CreditCard(
                        request.getCardHolderName(),
                        request.getCardNumber(),
                        Month.of(request.getExpiryMonth()),
                        Year.of(request.getExpiryYear())
                )
        );
        return ResponseEntity.ok(PaymentResponse.fromDomain(payment));
    }	
}
