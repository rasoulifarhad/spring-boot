package com.farhad.example.shop_demo.cart.api;

import lombok.Value;

@Value
public class UserId {
    private Long id;

    public static UserId NONE = new UserId(null);
    
}
