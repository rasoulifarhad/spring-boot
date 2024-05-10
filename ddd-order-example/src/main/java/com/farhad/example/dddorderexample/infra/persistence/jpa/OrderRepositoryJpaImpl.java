package com.farhad.example.dddorderexample.infra.persistence.jpa;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.farhad.example.dddorderexample.domain.model.Order;
import com.farhad.example.dddorderexample.domain.model.Order.OrderId;
import com.farhad.example.dddorderexample.domain.model.OrderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderRepositoryJpaImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public void saveOrder(Order order) {
        orderJpaRepository.save(order);
    }

    @Override
    public Order findByOrderId(String orderId) {
        return orderJpaRepository.getById(OrderId.of(orderId));
    }

    @Override
    public Collection<Order> findAllOrders() {
        return orderJpaRepository.findAll();
    }

}
