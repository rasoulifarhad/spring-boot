package com.farhad.example.dddhibernatedemo.dto;

import lombok.Data;

@Data
public class OrderItemDto {

    Long quantity;
    Long productId;
}
