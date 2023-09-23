package com.farhad.example.shop_demo.cart.internal.database.internal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
public class ArticleDatabaseEntity {
    
    @Id
    private Long id;
    private String name;
    private Long priceInCents;
}
