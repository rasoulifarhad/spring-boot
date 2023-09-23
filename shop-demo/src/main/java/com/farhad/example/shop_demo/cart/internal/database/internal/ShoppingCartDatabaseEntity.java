package com.farhad.example.shop_demo.cart.internal.database.internal;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "shopping_cart")
@Data
@AllArgsConstructor
public class ShoppingCartDatabaseEntity {
    
    @Id 
    private Long id;
    private Long userId;
    @MappedCollection(idColumn = "shopping_cart_id")
    private Set<ArticleRef> articles;    
}
