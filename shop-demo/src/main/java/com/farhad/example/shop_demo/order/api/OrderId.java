package com.farhad.example.shop_demo.order.api;

import lombok.Value;

@Value
public class OrderId {
    private Long id;


    public static OrderId NONE = new OrderId(null);    
}
