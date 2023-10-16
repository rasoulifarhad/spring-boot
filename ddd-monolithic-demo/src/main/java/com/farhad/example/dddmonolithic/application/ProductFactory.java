package com.farhad.example.dddmonolithic.application;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.farhad.example.dddmonolithic.domain.model.product.Product;
import com.farhad.example.dddmonolithic.domain.model.product.ProductPrice;


@Component
public class ProductFactory {
	protected static final ModelMapper mapper = new ModelMapper();

	public Product create(String name, String description, BigDecimal price, Boolean isOnSale) {
		return Product.builder()
					.name(name)
					.description(description)
					.price(ProductPrice.of(description, price))
					.isOnSale(isOnSale)
					.build();

	}
}
