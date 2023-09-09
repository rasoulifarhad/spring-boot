package com.farhad.example.hexagonalorderdemo.shop.application.port.in.product;

import java.util.List;

import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

public interface FindProductUseCase {
	List<Product> findByNameOrDescription(String query);
}
