package com.farhad.example.dddorderexample.application.service;

import com.farhad.example.dddorderexample.domain.model.Order;
import com.farhad.example.dddorderexample.domain.model.Payment;
import com.farhad.example.dddorderexample.domain.model.ShippingAddress;

public interface OrderService {

    void createOrder(Order order );
    void addShippingAddress(ShippingAddress shippingAddress );
    void addPaymentDetail(Payment payment);
    void applyDiscount();
}
