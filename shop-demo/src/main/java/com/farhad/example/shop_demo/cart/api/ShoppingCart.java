package com.farhad.example.shop_demo.cart.api;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.Data;

@Data
public class ShoppingCart {
    
    private final ShoppingCartId id;
    private final UserId userId;
    private final Map<ArticleId, ShoppingCartItem>  shoppingCartItems;
    
    public ShoppingCart(ShoppingCartId id, UserId userId, List<ShoppingCartItem> items) {
        this.id = Objects.requireNonNull(id);
        this.userId = Objects.requireNonNull(userId);
        Objects.requireNonNull(shoppingCartItems)
        this.shoppingCartItems = items.stream()
                                    .collect(toMap(ShoppingCartItem::getArticleId, identity()));
    }

    public static ShoppingCart createNew(UserId userId, List<ShoppingCartItem> items) {
        return new ShoppingCart(ShoppingCartId.NONE, userId, items);
    }

    public static ShoppingCart reconstitute(ShoppingCartId id, UserId userId, List<ShoppingCartItem> items) {
        return new ShoppingCart(id, userId, items);
    }

    public void addItem(ShoppingCartItem item) {
        Objects.requireNonNull(item);
        if(this.shoppingCartItems.size() >= 10) {
            throw new IllegalStateException("shopping cart may not contain more than 10 items at a time!");
        }
        this.shoppingCartItems.put(item.getArticleId(), item);
    }

    public void reset() {
        this.shoppingCartItems.clear();
    }

    public void removeItem(ArticleId articleId) {
        Objects.requireNonNull(articleId);
        this.shoppingCartItems.remove(articleId);
    }

    public Collection<ShoppingCartItem> getItems() {
        return this.getShoppingCartItems().values();
    }
    
}
