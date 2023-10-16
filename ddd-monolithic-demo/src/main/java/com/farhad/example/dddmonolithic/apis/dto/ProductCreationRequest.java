package com.farhad.example.dddmonolithic.apis.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductCreationRequest {
	
	private String name;

	private String description;

    private BigDecimal price;

}
