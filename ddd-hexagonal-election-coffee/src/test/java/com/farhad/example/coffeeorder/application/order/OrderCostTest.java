package com.farhad.example.coffeeorder.application.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.farhad.example.coffeeorder.shared.Drink;
import com.farhad.example.coffeeorder.shared.Location;
import com.farhad.example.coffeeorder.shared.Milk;
import com.farhad.example.coffeeorder.shared.Size;

public class OrderCostTest {

	private static Stream<Arguments> drinkCosts() {
		return Stream.of(
			arguments(1, Size.SMALL, BigDecimal.valueOf(4.0)),
			arguments(1, Size.LARGE, BigDecimal.valueOf(5.0)),
			arguments(2, Size.SMALL, BigDecimal.valueOf(8.0))
		);
	}

	@ParameterizedTest(name = "{0} drinks of size {1} cost {2}")
	@MethodSource("drinkCosts")
	public void orderCostIsBasedOnQuantityAndSize(int quantity, Size size, BigDecimal expectedCost) {
		Order order = new Order(
						Location.TAKE_AWAY, 
						Arrays.asList(
							new LineItem(
								Drink.LATTE, 
								Milk.WHOLE, 
								size, 
								quantity)));
		assertThat(order.getCost()).isEqualTo(expectedCost);
	}

	@Test
	public void orderCostIsSumOfLineItemCosts() {

		Order order = new Order(
						Location.TAKE_AWAY, 
						Arrays.asList(
							new LineItem(
								Drink.LATTE, 
								Milk.WHOLE, 
								Size.SMALL, 
								1),
								
							new LineItem(
								Drink.ESPRESSO, 
								Milk.SOY, 
								Size.LARGE, 
								1)));

		assertThat(order.getCost()).isEqualTo(BigDecimal.valueOf(9.0));
	}

}
