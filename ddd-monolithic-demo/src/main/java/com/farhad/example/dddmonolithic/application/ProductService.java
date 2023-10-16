package com.farhad.example.dddmonolithic.application;

import java.util.List;

import org.springframework.stereotype.Component;

import com.farhad.example.dddmonolithic.domain.model.product.Product;
import com.farhad.example.dddmonolithic.infrastructure.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long productId)  {
		return productRepository.findById(productId);
	}

	public Product save(Product product) {
        return productRepository.save(product);
    }
}
