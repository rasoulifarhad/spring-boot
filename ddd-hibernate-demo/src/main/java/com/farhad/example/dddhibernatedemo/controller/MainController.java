package com.farhad.example.dddhibernatedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public Long getOrder(@PathVariable("id") Long id) {
        Order byCustomerId = orderRepository.findByCustomerId(id);
        byCustomerId.getOrderItems().get(0).getProduct().getDescription();
        return 1L;
        
    }

    @GetMapping("/customers/orders2/{id}")
    public Long getOrder2(@PathVariable("id") Long id) {
        Order byCustomerId = orderRepository.findByCustomerIdCustomQuery(id);
        byCustomerId.getOrderItems().get(0).getProduct().getDescription();
        return 1L;
    }    

    @GetMapping("/customers/{id}")
    public Long getCustomer(@PathVariable("id") Long id) {
        customerRepository.findById(id).get();
        return 1L;
    }    


}
