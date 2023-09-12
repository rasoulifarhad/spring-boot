package com.farhad.example.dddorderdemo.bookstore.domain.model.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.dddorderdemo.bookstore.domain.model.user.User;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
	List<Order> findByUser(User user);
}
