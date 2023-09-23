package com.farhad.example.shop_demo.events;

import com.farhad.example.shop_demo.cart.api.ShoppingCart;

import lombok.Value;

@Value
public class CheckoutEvent {
    private final ShoppingCart ShoppingCart;
}
