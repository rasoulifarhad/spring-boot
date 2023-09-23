package com.farhad.example.shop_demo.cart.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import com.farhad.example.shop_demo.cart.api.Article;
import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.api.ShoppingCartService;
import com.farhad.example.shop_demo.cart.api.UserId;
import com.farhad.example.shop_demo.cart.internal.database.api.ShoppingCartDatabase;
import com.farhad.example.shop_demo.events.CheckoutEvent;

@JdbcTest
@Import(ShoppingCartConfiguration.class)
@RecordApplicationEvents
public class ShoppingCartDomainServiceTest {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ShoppingCartDatabase shoppingCartDatabase;

    @Autowired
    private ApplicationEvents applicationEvents;  
    
    private static final UserId USER_ID = new UserId(42L);    

    List<Article> givenArticlesInDatabase() {
        Article article1 = Article.createNew("Get Your Hands Dirty on Clean Architecture", 20000);
        Article article2 = Article.createNew("Modulithic Applications with Spring", 39000);

        List<Article> articles = new ArrayList<>();
        articles.add(shoppingCartDatabase.addArticle(article1));
        articles.add(shoppingCartDatabase.addArticle(article2));

        return articles;
    }   
    
    @Test
    ShoppingCart createShoppingCart() {
        List<Article> articles = givenArticlesInDatabase();

        shoppingCartService.addArticle(USER_ID, articles.get(0).getId());
        shoppingCartService.addArticle(USER_ID, articles.get(1).getId());
        ShoppingCart cart = shoppingCartService.getShoppingCart(USER_ID);
        assertThat(cart.getItems()).hasSize(2);

        return cart;
    }

    @Test
    void modifyShoppingCart() {
        ShoppingCart cart = createShoppingCart();
        assertThat(cart.getItems()).hasSize(2);

        shoppingCartService.removeArticle(USER_ID, cart.getItems().stream().findFirst().get().getArticleId());
        cart = shoppingCartService.getShoppingCart(USER_ID);
        assertThat(cart.getItems()).hasSize(1);
    }

    @Test
    void resetShoppingCart() {
        ShoppingCart cart = createShoppingCart();
        assertThat(cart.getItems()).hasSize(2);

        shoppingCartService.resetCart(USER_ID);
        cart = shoppingCartService.getShoppingCart(USER_ID);
        assertThat(cart.getItems()).isEmpty();
    }

    @Test
    void checkoutShoppingCart() {
        ShoppingCart cart = createShoppingCart();

        shoppingCartService.checkout(USER_ID);
        assertThat(applicationEvents.stream(CheckoutEvent.class)
                .count()).isEqualTo(1);
    }    
}
