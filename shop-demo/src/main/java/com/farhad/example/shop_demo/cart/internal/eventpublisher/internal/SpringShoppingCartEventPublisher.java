package com.farhad.example.shop_demo.cart.internal.eventpublisher.internal;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.internal.eventpublisher.api.ShoppingCartEventPublisher;
import com.farhad.example.shop_demo.events.CheckoutEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SpringShoppingCartEventPublisher implements ShoppingCartEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publishCheckoutEvent(ShoppingCart shoppingCart) {
        eventPublisher.publishEvent(new CheckoutEvent(shoppingCart));
    }
    
}
