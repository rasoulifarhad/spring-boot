package com.farhad.example.dddmonolithic.apis.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor	
@Data
public class ProductResponse {

	private String name;

	private String description;

    private BigDecimal price;
}
