package com.farhad.example.dddhibernatedemo.domain;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    Long id;

    String description;
    BigDecimal price;

    
    @ManyToMany
    List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY)
    Admin admin;

}
