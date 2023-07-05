package com.farhad.example.springrest.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.springrest.basic.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
