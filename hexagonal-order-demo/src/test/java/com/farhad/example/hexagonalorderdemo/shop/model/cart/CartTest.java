package com.farhad.example.hexagonalorderdemo.shop.model.cart;

import static com.farhad.example.hexagonalorderdemo.shop.model.money.TestMoneyFactory.euros;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;
import com.farhad.example.hexagonalorderdemo.shop.model.product.TestProductFactory;

public class CartTest {

	@Test
	public void given_EmptyCart_when_addTwoProducts_then_numberOfItems_and_subTotal_isCalculatedCorrectly() throws NotEnoughItemsInStockException {
		//given
		Cart cart = TestCartFactory.emptyCartForRandomCustomer();
		//when
		Product product1 = TestProductFactory.createTestProduct(euros(12, 99));
		Product product2 = TestProductFactory.createTestProduct(euros(5, 97));
		cart.addProduct(product1, 3);;
		cart.addProduct(product2, 5);
		//then
		assertThat(cart.numberOfItems()).isEqualTo(8);
		assertThat(cart.subTotal()).isEqualTo(euros(68, 82));

	}
}
