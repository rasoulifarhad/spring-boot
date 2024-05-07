package com.farhad.example.dddhibernatedemo.domain;

import com.farhad.example.dddhibernatedemo.dto.OrderItemDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue
    Long id;
    Long quantity;
    
    @ManyToOne
    Product product;

    @ManyToOne
    Order order;

    public static OrderItem fromDto(OrderItemDto dto, Product product) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItem.getQuantity());
        orderItem.setProduct(product);
        return orderItem;

    }

}
