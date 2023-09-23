package com.farhad.example.shop_demo.cart.api;

import java.util.Objects;

import lombok.Data;

@Data
public class Article {
   
    private final ArticleId id;
    private final String name;
    private final Long pricrInCents;
    
    public Article(ArticleId id, String name, Long pricrInCents) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.pricrInCents = Objects.requireNonNull(pricrInCents);
    }

    public static Article createNew(String name, long priceInCents) {
        return new Article(ArticleId.NONE, name, priceInCents);
    }

    public static Article reconstitute(ArticleId id, String name, long priceInCents) {
        return new Article(id, name, priceInCents);
    }
}
