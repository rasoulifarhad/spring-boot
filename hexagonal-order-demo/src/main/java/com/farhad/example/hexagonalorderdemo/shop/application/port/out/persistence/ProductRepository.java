package com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence;

import java.util.List;
import java.util.Optional;

import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;
import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

public interface ProductRepository {

	List<Product> findByNameOrDescription(String query);

	Optional<Product> findById(ProductId productId);

	void save(Product product);
	
}
