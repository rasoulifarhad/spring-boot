package com.farhad.example.shop_demo.cart.internal.eventpublisher.api;

import com.farhad.example.shop_demo.cart.api.ShoppingCart;

public interface ShoppingCartEventPublisher {
    void publishCheckoutEvent(ShoppingCart shoppingCart);
}
