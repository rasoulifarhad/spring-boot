package com.farhad.example.shop_demo.order.api;

import com.farhad.example.shop_demo.cart.api.ArticleId;

import lombok.Value;

@Value
public class OrderItem {
    
    private final ArticleId articleId;
    private final long amount;
    private long priceInCents;
}
