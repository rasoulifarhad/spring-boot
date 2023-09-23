package com.farhad.example.shop_demo.order.internal.database.internal;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<OrderDatabaseEntity, Long>{
    
}
