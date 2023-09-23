package com.farhad.example.shop_demo.cart.internal.database.internal;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.farhad.example.shop_demo.cart.api.Article;
import com.farhad.example.shop_demo.cart.api.ArticleId;
import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.api.UserId;
import com.farhad.example.shop_demo.cart.internal.database.api.ShoppingCartDatabase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SpringJdbcShoppingCartDatabase implements ShoppingCartDatabase {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ArticleRepository articleRepository;

    @Override
    public Optional<ShoppingCart> loadShoppingCartByUserId(UserId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadShoppingCartByUserId'");
    }

    @Override
    public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveShoppingCart'");
    }

    @Override
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateShoppingCart'");
    }

    @Override
    public Article addArticle(Article article) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addArticle'");
    }

    @Override
    public Optional<Article> loadArticle(ArticleId articleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadArticle'");
    }
    
}
