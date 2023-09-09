package com.farhad.example.hexagonalorderdemo.shop.application.service.product;

import static com.farhad.example.hexagonalorderdemo.shop.model.money.TestMoneyFactory.euros;
import static com.farhad.example.hexagonalorderdemo.shop.model.product.TestProductFactory.createTestProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.ProductRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

public class FindProductServiceTest {

	private static final Product TEST_PRODUCT_1 = createTestProduct(euros(19, 99));
	private static final Product TEST_PRODUCT_2 = createTestProduct(euros(25, 99));

	private final ProductRepository productRepository = mock(ProductRepository.class);
	private final FindProductService findProductService = new FindProductService(productRepository);

	@Test
	public void given_searchQuery_when_findByNameOrDescription_then_returnedProductsPersisted() {

		//given
		when(productRepository.findByNameOrDescription("one"))
					.thenReturn(
						new ArrayList<Product>(
							Arrays.asList(TEST_PRODUCT_1)));
		when(productRepository.findByNameOrDescription("two"))
					.thenReturn(
						new ArrayList<Product>(
							Arrays.asList(TEST_PRODUCT_2)));
		when(productRepository.findByNameOrDescription("one-two"))
					.thenReturn(new ArrayList<Product>(Arrays.asList(TEST_PRODUCT_1, TEST_PRODUCT_2)));
		when(productRepository.findByNameOrDescription("empty"))
					.thenReturn(Collections.emptyList());
		//when
		//then
		assertThat(findProductService.findByNameOrDescription("one")).containsExactly(TEST_PRODUCT_1);
		assertThat(findProductService.findByNameOrDescription("two")).containsExactly(TEST_PRODUCT_2);
		assertThat(findProductService.findByNameOrDescription("one-two")).containsExactly(TEST_PRODUCT_1, TEST_PRODUCT_2);
		assertThat(findProductService.findByNameOrDescription("empty")).isEmpty();
	}
}
