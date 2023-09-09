package com.farhad.example.hexagonalorderdemo.shop.application.service.cart;

import static com.farhad.example.hexagonalorderdemo.shop.model.money.TestMoneyFactory.euros;
import static com.farhad.example.hexagonalorderdemo.shop.model.product.TestProductFactory.createTestProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.NotEnoughItemsInStockException;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;

public class GetCartServiceTest {

	private static final CustomerId TEST_CUSTOMER_ID = new CustomerId(12345);
	private static final Product TEST_PRODUCT_1 = createTestProduct(euros(19, 99));
	private static final Product TEST_PRODUCT_2 = createTestProduct(euros(25, 99));

	private CartRepository cartRepository = mock(CartRepository.class);
	private GetCartService getCartService = new GetCartService(cartRepository);

	@Test
	public void given_cartIsPresisted_when_getCart_then_returnsPersistedCart() throws NotEnoughItemsInStockException {
		//given
		Cart persistedCart = new Cart(TEST_CUSTOMER_ID);
		persistedCart.addProduct(TEST_PRODUCT_1, 1);
		persistedCart.addProduct(TEST_PRODUCT_2, 2);

		when(cartRepository.findByCustomerId(TEST_CUSTOMER_ID))
					.thenReturn(Optional.of(persistedCart));
		//when
		Cart cart = getCartService.getCart(TEST_CUSTOMER_ID);
		//then
		assertThat(cart).isSameAs(persistedCart);
	}

	@Test
	public void given_cartIsNotPresisted_when_getCart_then_returnsEmptyCart() throws NotEnoughItemsInStockException {
		//given

		when(cartRepository.findByCustomerId(TEST_CUSTOMER_ID))
					.thenReturn(Optional.empty());
		//when
		Cart cart = getCartService.getCart(TEST_CUSTOMER_ID);
		//then
		assertThat(cart).isNotNull();
		assertThat(cart.lineItems()).isEmpty();
	}

}
