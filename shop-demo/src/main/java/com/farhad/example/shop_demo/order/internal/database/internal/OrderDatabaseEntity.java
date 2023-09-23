package com.farhad.example.shop_demo.order.internal.database.internal;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
public class OrderDatabaseEntity {
    
    @Id
    private Long id;
    private Long userId;
    private LocalDateTime orderDate;
}
