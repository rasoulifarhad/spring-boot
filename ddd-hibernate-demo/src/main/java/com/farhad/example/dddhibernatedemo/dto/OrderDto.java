package com.farhad.example.dddhibernatedemo.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDto {

    Long customerId;
    BigDecimal totalPrice;
}
