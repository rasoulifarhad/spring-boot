package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence;

import static com.farhad.example.hexagonalorderdemo.shop.model.money.TestMoneyFactory.euros;
import static com.farhad.example.hexagonalorderdemo.shop.model.product.TestProductFactory.createTestProduct;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.ProductRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

public abstract class AbstractCartRepositoryTest<T extends CartRepository, U extends ProductRepository> {
	
	private static final Product TEST_PRODUCT_1 = createTestProduct(euros(19, 99));
	private static final Product TEST_PRODUCT_2 = createTestProduct(euros(1, 49));

	private static final AtomicInteger 	CUSTOMER_IDSEQUENCE_GENERATOR = new AtomicInteger();

	private T cartRepository;

	protected abstract T createCartRepository();
	protected abstract U createProductRepository();

	@BeforeEach
	void initRepository() {
		cartRepository = createCartRepository();
		persistTestProduct();
	}

	private void persistTestProduct() {
		U productRepository = createProductRepository();
		productRepository.save(TEST_PRODUCT_1);
		productRepository.save(TEST_PRODUCT_2);
	}

	@Test
	public void given_customerIdWithNoCart_when_findByCustomerId_then_returnEmptyCart() {
		//given
		CustomerId customerId = createUniqieCustomerId();
		//when
		Optional<Cart> cart = cartRepository.findByCustomerId(customerId);
		//then
		assertThat(cart).isEmpty();
	}

	@Test
	public void given_customerIdWithNoCart_when_deleteByCustomerId_then_doseNothing() {
		//given
		CustomerId customerId = createUniqieCustomerId();
		assertThat(cartRepository.findByCustomerId(customerId)).isEmpty();
		//when
		cartRepository.deleteById(customerId);
		//then
		assertThat(cartRepository.findByCustomerId(customerId)).isEmpty();
	}

	@Test
	public void given_customerIdWithCart_when_deleteByCustomerId_then_deleteThatCart() {
		//given
		CustomerId customerId = createUniqieCustomerId();
		Cart cart = new Cart(customerId);
		cartRepository.save(cart);
		assertThat(cartRepository.findByCustomerId(customerId)).isNotEmpty();

		//when
		cartRepository.deleteById(customerId);
		//then
		assertThat(cartRepository.findByCustomerId(customerId)).isEmpty();
	}

	private CustomerId createUniqieCustomerId() {
		return new CustomerId(CUSTOMER_IDSEQUENCE_GENERATOR.incrementAndGet());
	}

}
