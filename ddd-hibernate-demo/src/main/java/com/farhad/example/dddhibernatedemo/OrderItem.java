package com.farhad.example.dddhibernatedemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue
    Long id;
    Long quantity;
    
    @ManyToOne
    Product product;

    @ManyToOne
    Order order;

}
