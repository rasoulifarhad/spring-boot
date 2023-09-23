package com.farhad.example.shop_demo.cart.api;

import lombok.Value;

@Value
public class ArticleId {
    
    private Long id;

    public static ArticleId NONE = new ArticleId(null);    
}
