package com.farhad.example.shop_demo.cart.internal.database.internal;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "shopping_cart_article")
@Data
@AllArgsConstructor
public class ArticleRef {
    
    private Long articleId;
}
