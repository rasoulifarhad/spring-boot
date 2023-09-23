package com.farhad.example.shop_demo.cart.internal.database.api;

import java.util.Optional;

import com.farhad.example.shop_demo.cart.api.Article;
import com.farhad.example.shop_demo.cart.api.ArticleId;
import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.api.UserId;

public interface ShoppingCartDatabase {
    
    Optional<ShoppingCart> loadShoppingCartByUserId(UserId id);

    ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);

    void updateShoppingCart(ShoppingCart shoppingCart);

    Article addArticle(Article article);

    Optional<Article> loadArticle(ArticleId articleId);

}
