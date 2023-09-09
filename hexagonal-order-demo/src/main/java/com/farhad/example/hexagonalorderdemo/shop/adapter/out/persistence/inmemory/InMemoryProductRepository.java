package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.inmemory;

import java.util.List;
import java.util.Optional;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.ProductRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;
import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

public class InMemoryProductRepository implements ProductRepository {

	@Override
	public List<Product> findByNameOrDescription(String query) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByNameOrDescription'");
	}

	@Override
	public Optional<Product> findById(ProductId productId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}
	
}
