package com.farhad.example.dddorderexample.application.service;

import com.farhad.example.dddorderexample.application.api.dto.OrderDto;
import com.farhad.example.dddorderexample.application.api.dto.PaymentDto;
import com.farhad.example.dddorderexample.application.api.dto.ShippingAddressDto;

public interface OrderService {

    void createOrder(OrderDto orderDto );
    void addShippingAddress(ShippingAddressDto shippingAddressDto );
    void addPaymentDetail(PaymentDto paymentDto);
    void applyDiscount();
}
