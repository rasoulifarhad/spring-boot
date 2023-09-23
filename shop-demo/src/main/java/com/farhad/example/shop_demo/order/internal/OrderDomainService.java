package com.farhad.example.shop_demo.order.internal;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.farhad.example.shop_demo.cart.api.ShoppingCart;
import com.farhad.example.shop_demo.cart.api.ShoppingCartItem;
import com.farhad.example.shop_demo.order.api.Order;
import com.farhad.example.shop_demo.order.api.OrderItem;
import com.farhad.example.shop_demo.order.internal.database.api.OrderDatabase;

import lombok.RequiredArgsConstructor;

@Component
@Transactional
@RequiredArgsConstructor
public class OrderDomainService {
  
    private final OrderDatabase orderDatabase;   
    
    public void createOrderFromCart(ShoppingCart cart) {
        Objects.requireNonNull(cart);
        Order order = fromShoppingCart(cart);

        orderDatabase.saveOrder(order);
    }

    private Order fromShoppingCart(ShoppingCart cart) {
        return Order.createNew(fromShoppingCartItems(cart.getItems()), cart.getUserId().getId());    
    }

    private List<OrderItem> fromShoppingCartItems(Collection<ShoppingCartItem> shoppingCartItems) {
        return shoppingCartItems.stream()
                .map(i -> new OrderItem(i.getArticleId(), i.getAmount(), i.getPriceInCents()))
                .collect(toList());    
    }
}
