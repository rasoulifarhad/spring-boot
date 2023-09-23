package com.farhad.example.shop_demo.cart.internal;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.farhad.example.shop_demo.cart.api.ArticleId;
import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.api.ShoppingCartService;
import com.farhad.example.shop_demo.cart.api.UserId;
import com.farhad.example.shop_demo.cart.internal.database.api.ShoppingCartDatabase;
import com.farhad.example.shop_demo.cart.internal.eventpublisher.api.ShoppingCartEventPublisher;

import lombok.RequiredArgsConstructor;

@Component
@Transactional
@RequiredArgsConstructor
public class ShoppingCartDomainService implements ShoppingCartService {

    private final ShoppingCartDatabase database;

    private final ShoppingCartEventPublisher shoppingCartEventPublisher;

    @Override
    public void addArticle(UserId userId, ArticleId articleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addArticle'");
    }

    @Override
    public void removeArticle(UserId userId, ArticleId articleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeArticle'");
    }

    @Override
    public void resetCart(UserId userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetCart'");
    }

    @Override
    public void checkout(UserId userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkout'");
    }

    @Override
    public ShoppingCart geShoppingCart(UserId userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'geShoppingCart'");
    }
    
}
