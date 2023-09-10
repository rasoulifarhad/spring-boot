package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.ProductRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

public abstract class AbstractProductRepositoryTest<T extends ProductRepository> {
	
	T productRepository;
	protected abstract T createProductRepository();

	@BeforeEach
	void initRepository() {
		productRepository = createProductRepository();
	}

	@Test
	public void given_testProducts_when_findByNameOrDescriptionMatchingOneProduct_then_returnMatchingProduct() {
		// given
		final String query = "lights";
		//when
		List<Product> currentProducts = productRepository.findByNameOrDescription(query);

		//then
		assertThat(currentProducts).containsExactlyInAnyOrder(DemoProducts.LED_LIGHTS);
	}

	@Test
	public void given_testProducts_when_findByNameOrDescription_then_returnMatchingProducts() {
		// given
		final String query = "monitor";
		//when
		List<Product> currentProducts = productRepository.findByNameOrDescription(query);

		//then
		assertThat(currentProducts).containsExactlyInAnyOrder(DemoProducts.COMPUTER_MONITOR, DemoProducts.MONITOR_DESK_MOUNT);
	}

	@Test
	public void given_testProducts_when_findByNameOrDescriptionNotMatchingAnyProduct_then_returnEmptyList() {
		// given
		final String query = "not matching any products";
		//when
		List<Product> currentProducts = productRepository.findByNameOrDescription(query);

		//then
		assertThat(currentProducts).isEmpty();
	}

}
