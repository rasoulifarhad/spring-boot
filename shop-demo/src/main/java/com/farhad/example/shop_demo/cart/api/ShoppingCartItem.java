package com.farhad.example.shop_demo.cart.api;

import lombok.Value;

@Value
public class ShoppingCartItem {

    private ArticleId articleId;
    private int amount;
    private long priceInCents;
}
