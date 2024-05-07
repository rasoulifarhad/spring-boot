package com.farhad.example.dddhibernatedemo.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.dddhibernatedemo.dto.OrderDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@NamedEntityGraph(
    name = "order-join-shipping",
    attributeNodes = {
        @NamedAttributeNode("shippingAddress"),
        @NamedAttributeNode(value = "orderItems", subgraph = "orderItemProduct")
    },
    subgraphs = {
        @NamedSubgraph(
            name = "orderItemProduct",
            attributeNodes = { 
                @NamedAttributeNode("product")
            })
    })
@Entity
@Data
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    Long id;

    Long customerId;

    BigDecimal totalPrice;

    @ManyToOne
    Address shippingAddress;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    List<OrderItem> orderItems = new ArrayList<>();
    // Derived Value

    public long getOrderItemsCount() {
        return orderItems.size();
    }

    // Derived Value
    public long getTotalQuantity() {
        return orderItems.stream().mapToLong(OrderItem::getQuantity).sum();
    }

    public void addProduct(Product product, long quantity) {
        orderItems.stream()
                .filter(orderItem -> orderItem.getProduct().equals(product))
                .findFirst()
                .ifPresentOrElse(
                        orderItem -> orderItem.setQuantity(orderItem.getQuantity() + quantity),
                        () -> addNewOrderItem(product, quantity));

        totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
    }

    private void addNewOrderItem(Product product, long quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setOrder(this);
        orderItems.add(orderItem);
    }

    public static Order createQuickOrder(Customer customer, Product product) {
        Order order = new Order();
        order.setCustomerId(customer.getId());
        order.addProduct(product, 1);
        order.validate();
        return order;
    }

    public static Order createOrderFromOrderItems(Customer customer, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setCustomerId(customer.getId());
        order.setOrderItems(orderItems);
        order.setTotalPrice(order.orderItemsTotalPrice());
        order.validate();
        return order;
    }

    private void validate() {
        if (orderItems.isEmpty()) {
            throw new IllegalStateException("Order must have at least one item");
        }

        if (totalPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalStateException("Order total price must be greater than zero");
        }

        if (totalPrice.compareTo(orderItemsTotalPrice()) != 0) {
            throw new IllegalStateException("Order total price must match sum of order items prices");
        }
    }

    private BigDecimal orderItemsTotalPrice() {
        return orderItems.stream()
                .map(
                        orderItem -> orderItem
                                .getProduct()
                                .getPrice()
                                .multiply(BigDecimal.valueOf(orderItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public OrderDto toDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerId(customerId);
        orderDto.setTotalPrice(totalPrice);
        return orderDto;
    }
}
