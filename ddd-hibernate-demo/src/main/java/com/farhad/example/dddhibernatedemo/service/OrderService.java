package com.farhad.example.dddhibernatedemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.farhad.example.dddhibernatedemo.domain.Customer;
import com.farhad.example.dddhibernatedemo.domain.Order;
import com.farhad.example.dddhibernatedemo.domain.OrderItem;
import com.farhad.example.dddhibernatedemo.domain.Product;
import com.farhad.example.dddhibernatedemo.dto.OrderDto;
import com.farhad.example.dddhibernatedemo.dto.OrderItemDto;
import com.farhad.example.dddhibernatedemo.repository.OrderRepository;
import com.farhad.example.dddhibernatedemo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderDto createNewOrder(Customer customer, List<OrderItemDto> orderItemDtos) {
        Order order = 
            Order.createOrderFromOrderItems(customer,
                orderItemDtos.stream().map(this::createOrderItemFromDto).toList());
        orderRepository.save(order);
        return order.toDto();
    }

    private OrderItem createOrderItemFromDto(OrderItemDto dto) {
        Product product = productRepository.findById(dto.getProductId()).get();
        return OrderItem.fromDto(dto, product);
    }
}
