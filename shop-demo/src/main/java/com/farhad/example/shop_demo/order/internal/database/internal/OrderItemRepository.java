package com.farhad.example.shop_demo.order.internal.database.internal;

import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItemDatabaseEntity, Long> {
    
}
