package com.farhad.example.hexagonalorderdemo.shop.application.service.product;

import java.util.List;
import java.util.Objects;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.product.FindProductUseCase;
import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.ProductRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindProductService implements FindProductUseCase {

	private final ProductRepository productRepository;
	@Override
	public List<Product> findByNameOrDescription(String query) {
		Objects.requireNonNull(query, "query must not be null");
		if(query.trim().length() < 2) {
			throw new IllegalArgumentException("query must be at least two characters long");
		}
		return productRepository.findByNameOrDescription(query);
	}
	
}
