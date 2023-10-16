package com.farhad.example.dddmonolithic.infrastructure.repositories;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.farhad.example.dddmonolithic.domain.model.product.Product;
import com.farhad.example.dddmonolithic.infrastructure.repositories.dataentity.ProductDataEntity;
import com.farhad.example.dddmonolithic.infrastructure.repositories.persistence.ProductJpaPersistence;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductRepository {

	protected static final ModelMapper mapper = new ModelMapper();
	
	private final ProductJpaPersistence repository;

	public Product save(Product product) {
		return
			mapper.map( 
				repository.save(
							mapper.map(product, ProductDataEntity.class)), Product.class);
	}

	public Product findById(Long id) {
		return 
			repository.findById(id)
				.map(e -> mapper.map(e, Product.class))
				.orElse(null);
	}

	public List<Product> findAll() {
		return repository.findAll().stream()
					.map(e -> mapper.map(e, Product.class))
					.collect(toList());

	}

}
