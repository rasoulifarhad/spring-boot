package com.farhad.example.shop_demo.order.internal.database.internal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "order_item")
@Data
@AllArgsConstructor
public class OrderItemDatabaseEntity {
    
    @Id 
    private Long id;
    private Long orderId;
    private Long amount;
    private Long articleId;
    private Long priceInCents    ;
}
