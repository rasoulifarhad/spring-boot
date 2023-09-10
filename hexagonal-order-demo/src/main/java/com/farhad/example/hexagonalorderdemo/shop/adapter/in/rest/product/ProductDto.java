package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.product;

import com.farhad.example.hexagonalorderdemo.shop.model.money.Money;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

import lombok.Data;

@Data
public class ProductDto {

	private String  id;
	private String name;
	private String description;
	private Money price;
	private int itemsInStock;

	public static ProductDto fromDomainModel(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.id().getValue());
		productDto.setDescription(product.description());
		productDto.setName(product.name());
		productDto.setPrice(product.price());
		productDto.setItemsInStock(product.itemsInStock());
		return productDto;
	}	
}
