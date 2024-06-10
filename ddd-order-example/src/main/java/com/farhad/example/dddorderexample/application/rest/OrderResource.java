package com.farhad.example.dddorderexample.application.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.dddorderexample.application.service.OrderService;
import com.farhad.example.dddorderexample.domain.model.Order;
import com.farhad.example.dddorderexample.domain.model.ShippingAddress;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @PostMapping("/orders/{orderId}/shippingAddresses")
    public void createOrder(@PathVariable("orderId") String orderId, @RequestBody ShippingAddress shippingAddress) {
        shippingAddress.wait
        orderService.createOrder(order);
    }
    
}
