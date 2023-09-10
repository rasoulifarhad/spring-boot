package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.inmemory;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.DemoProducts;
import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.ProductRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;
import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

public class InMemoryProductRepository implements ProductRepository {

	private final static Map<ProductId, Product> products = new ConcurrentHashMap<>();

	public InMemoryProductRepository() {
		saveDemoProducts();
	}

	private void saveDemoProducts() {
		DemoProducts.DEMO_PRODUCTS.forEach(this::save);
	}

	@Override
	public List<Product> findByNameOrDescription(String query) {
		return 
			products.values().stream()
				.filter(p -> 
					p.name().toLowerCase().contains(query.toLowerCase()) || 
					p.description().toLowerCase().contains(query.toLowerCase())
				)
				.collect(toList());
	}

	@Override
	public Optional<Product> findById(ProductId productId) {
		return Optional.ofNullable(products.get(productId));
	}

	@Override
	public void save(Product product) {
		products.put(product.id(), product);
	}
	
}
