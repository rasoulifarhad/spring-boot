package com.farhad.example.shop_demo.cart.api;

public interface ShoppingCartService {
    
    void addArticle(UserId userId, ArticleId articleId);
    void removeArticle(UserId userId, ArticleId articleId);
    void resetCart(UserId userId);
    void checkout(UserId userId);
    ShoppingCart geShoppingCart(UserId userId);
}
