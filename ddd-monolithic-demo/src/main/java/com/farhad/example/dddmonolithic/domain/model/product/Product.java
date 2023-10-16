package com.farhad.example.dddmonolithic.domain.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

	private Long id;
	
    private String name;


    private String description;

    private ProductPrice price;

    private Boolean isOnSale;
	
	
	public Product(Long id, String name, String description, ProductPrice price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}


	
}
