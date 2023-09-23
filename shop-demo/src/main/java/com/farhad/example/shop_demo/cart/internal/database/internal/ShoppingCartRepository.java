package com.farhad.example.shop_demo.cart.internal.database.internal;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCartDatabaseEntity, Long> {
    Optional<ShoppingCartDatabaseEntity> findByUserId(Long userId);    
}
