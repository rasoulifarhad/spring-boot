package com.farhad.example.shop_demo.order.internal.database.internal;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.farhad.example.shop_demo.cart.api.ArticleId;
import com.farhad.example.shop_demo.order.api.Order;
import com.farhad.example.shop_demo.order.api.OrderId;
import com.farhad.example.shop_demo.order.api.OrderItem;
import com.farhad.example.shop_demo.order.internal.database.api.OrderDatabase;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SpringJdbcOrderDatabase  implements OrderDatabase{

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Order saveOrder(Order order) {
        OrderDatabaseEntity savedOrder = orderRepository.save(fromDomainObject(order));
        List<OrderItemDatabaseEntity> orderItems = fromDomainObject(savedOrder.getId(), order.getItems());
        Iterable<OrderItemDatabaseEntity> savedItems = orderItemRepository.saveAll(orderItems);

        return toDomainObject(savedOrder, savedItems);
    }

   private Order toDomainObject(OrderDatabaseEntity order, Iterable<OrderItemDatabaseEntity> items) {
        return Order.reconstitute(
                new OrderId(order.getId()), 
                order.getUserId(), 
                toDomainObject(items));
    }

 private List<OrderItem> toDomainObject(Iterable<OrderItemDatabaseEntity> items) {
    return StreamSupport.stream(items.spliterator(), false)
                    .map(i -> new OrderItem(new ArticleId(i.getArticleId()), 1, i.getArticleId()))
                    .collect(toList());
}

private List<OrderItemDatabaseEntity> fromDomainObject(Long orderId, List<OrderItem> items) {
        return items.stream()
                    .map(i -> 
                        new OrderItemDatabaseEntity(
                                i.getArticleId().getId(), 
                                orderId, 
                                i.getAmount(), 
                                i.getArticleId().getId(), 
                                i.getPriceInCents()))
                    .collect(toList());
    }

    private OrderDatabaseEntity fromDomainObject(Order order) {
        return new OrderDatabaseEntity(
                    order.getOrderId().getId(), 
                    order.getUserId(), 
                    order.getOrderDate());
    }
    
}
