package com.farhad.example.dddorderexample.application.service;

import org.springframework.stereotype.Service;

import com.farhad.example.dddorderexample.domain.model.Order;
import com.farhad.example.dddorderexample.domain.model.OrderRepository;
import com.farhad.example.dddorderexample.domain.model.Payment;
import com.farhad.example.dddorderexample.domain.model.ShippingAddress;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.saveOrder(order);
    }

    @Override
    public void addShippingAddress(ShippingAddress shippingAddress) {
    }

    @Override
    public void addPaymentDetail(Payment payment) {
    }

    @Override
    public void applyDiscount() {
    }

}
