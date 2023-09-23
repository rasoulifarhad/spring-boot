package com.farhad.example.shop_demo.cart.internal;

import static java.util.Collections.emptyList;
import static java.util.Objects.requireNonNull;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.farhad.example.shop_demo.cart.api.Article;
import com.farhad.example.shop_demo.cart.api.ArticleId;
import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.api.ShoppingCartItem;
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
        requireNonNull(userId);
        requireNonNull(articleId);

        ShoppingCart cart = database.loadShoppingCartByUserId(userId)
                                .orElse(createNewShoppingCart(userId));
        Article article = database.loadArticle(articleId)
                                .orElseThrow(() -> new RuntimeException("Article not found: " + articleId));
        cart.addItem(
            new ShoppingCartItem(
                        articleId, 
                        1, 
                        article.getPricrInCents()));                
        database.saveShoppingCart(cart);
    }

    private ShoppingCart createNewShoppingCart(UserId userId) {
        ShoppingCart cart = ShoppingCart.createNew(userId, emptyList());
        return database.saveShoppingCart(cart);
    }

    @Override
    public void removeArticle(UserId userId, ArticleId articleId) {
        requireNonNull(userId);
        requireNonNull(articleId);

        ShoppingCart cart = database.loadShoppingCartByUserId(userId)
                                .orElseThrow(() -> new RuntimeException("Cart not found for user: " + userId));
        cart.removeItem(articleId);
        database.saveShoppingCart(cart);
    }

    @Override
    public void resetCart(UserId userId) {
        requireNonNull(userId);
        ShoppingCart cart = database.loadShoppingCartByUserId(userId)
                                .orElseThrow(() -> new RuntimeException("Cart not found for user: " + userId));
        cart.reset();
        database.saveShoppingCart(cart)            ;
    }

    @Override
    public void checkout(UserId userId) {
        requireNonNull(userId);
        ShoppingCart cart = database.loadShoppingCartByUserId(userId)
                                .orElseThrow(() -> new RuntimeException("Cart not found for user: " + userId));
        shoppingCartEventPublisher.publishCheckoutEvent(cart);            
        resetCart(userId);
    }

    @Override
    public ShoppingCart geShoppingCart(UserId userId) {
        requireNonNull(userId);
        return database.loadShoppingCartByUserId(userId)
                                .orElseThrow(() -> new RuntimeException("Cart not found for user: " + userId));
    }
    
}
