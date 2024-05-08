package com.farhad.example.dddhibernatedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.dddhibernatedemo.domain.Customer;
import com.farhad.example.dddhibernatedemo.domain.Order;
import com.farhad.example.dddhibernatedemo.repository.CustomerRepository;
import com.farhad.example.dddhibernatedemo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/customers/orders/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        Order byCustomerId = orderRepository.findByCustomerId(id);
        byCustomerId.getOrderItems().get(0).getProduct().getDescription();
        return byCustomerId;
        
    }

    @GetMapping("/customers/orders2/{id}")
    public Order getOrder2(@PathVariable("id") Long id) {
        Order byCustomerId = orderRepository.findByCustomerIdCustomQuery(id);
        byCustomerId.getOrderItems().get(0).getProduct().getDescription();
        return byCustomerId;
    }    

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerRepository.findById(id).get();
    }    


}
