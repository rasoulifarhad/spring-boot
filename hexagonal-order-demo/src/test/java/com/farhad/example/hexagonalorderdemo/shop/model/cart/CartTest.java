package com.farhad.example.hexagonalorderdemo.shop.model.cart;

import static com.farhad.example.hexagonalorderdemo.shop.model.cart.TestCartFactory.emptyCartForRandomCustomer;
import static com.farhad.example.hexagonalorderdemo.shop.model.money.TestMoneyFactory.euros;
import static com.farhad.example.hexagonalorderdemo.shop.model.product.TestProductFactory.createTestProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;
import com.farhad.example.hexagonalorderdemo.shop.model.product.TestProductFactory;

public class CartTest {

	@Test
	public void given_emptyCart_when_addTwoProducts_then_productsAreInCart() throws NotEnoughItemsInStockException {
		//given
		Cart cart = emptyCartForRandomCustomer();
		//when
		Product product1 = createTestProduct(euros(12, 99));
		Product product2 = createTestProduct(euros(5, 97));
		cart.addProduct(product1, 3);
		cart.addProduct(product2, 5);
		//then
		assertThat(cart.lineItems()).hasSize(2);
		assertThat(cart.lineItems().get(0).product()).isEqualTo(product1);
		assertThat(cart.lineItems().get(0).quantity()).isEqualTo(3);
		assertThat(cart.lineItems().get(1).product()).isEqualTo(product2);
		assertThat(cart.lineItems().get(1).quantity()).isEqualTo(5);
	}

	@Test
	public void given_EmptyCart_when_addTwoProducts_then_numberOfItems_and_subTotal_isCalculatedCorrectly() throws NotEnoughItemsInStockException {
		//given
		Cart cart = emptyCartForRandomCustomer();
		//when
		Product product1 = createTestProduct(euros(12, 99));
		Product product2 = createTestProduct(euros(5, 97));
		cart.addProduct(product1, 3);;
		cart.addProduct(product2, 5);
		//then
		assertThat(cart.numberOfItems()).isEqualTo(8);
		assertThat(cart.subTotal()).isEqualTo(euros(68, 82));
	}

	@Test
	public void given_aProductWithAFewItemAvailable_when_addMoreItemsThanAvailableToCart_then_throwsException() {
		//given
		Cart cart = emptyCartForRandomCustomer();
		//when
		Product product = TestProductFactory.createTestProduct(euros(12, 99), 3);
		//then
		assertThrows(
			NotEnoughItemsInStockException.class, 
			() -> cart.addProduct(product, 10));
	}
}
