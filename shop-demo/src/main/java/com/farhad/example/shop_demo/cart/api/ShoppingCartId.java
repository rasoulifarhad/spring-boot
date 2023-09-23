package com.farhad.example.shop_demo.cart.api;

import lombok.Value;

@Value
public class ShoppingCartId {
    
    private Long value;

    public static ShoppingCartId NONE = new ShoppingCartId(null);    
}
