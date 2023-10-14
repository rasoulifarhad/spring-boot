package com.farhad.example.coffeeorder.application;

import static com.farhad.example.coffeeorder.application.order.OrderTestFactory.aPaidOrder;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.coffeeorder.application.in.OrderingCoffee;
import com.farhad.example.coffeeorder.application.in.PreparingCoffee;
import com.farhad.example.coffeeorder.application.order.LineItem;
import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.application.out.Payments;
import com.farhad.example.coffeeorder.application.out.stub.InMemoryOrders;
import com.farhad.example.coffeeorder.application.out.stub.InMemoryPayments;
import com.farhad.example.coffeeorder.shared.Drink;
import com.farhad.example.coffeeorder.shared.Location;
import com.farhad.example.coffeeorder.shared.Milk;
import com.farhad.example.coffeeorder.shared.Size;
import com.farhad.example.coffeeorder.shared.Status;

public class AcceptanceTests {

	private Orders orders;
	private Payments payments;
	private OrderingCoffee customer;
	private PreparingCoffee barista;

	@BeforeEach
	public void setuo() {
		orders = new InMemoryOrders();
		payments = new InMemoryPayments();
		customer = new CoffeeShop(orders, payments);
		barista = new CoffeeMachine(orders);
	}

	@Test
	public void customerCanOrderCoffee() {
		Order orderToTake = new Order(Location.IN_STORE, 
				Arrays.asList(new LineItem(
					Drink.CAPPUCCINO,
					Milk.SKIMMED,
					Size.SMALL,
					1)));

		Order order = customer.placeOrder(orderToTake);

		assertThat(order.getLocation()).isEqualTo(Location.IN_STORE);
		assertThat(order.getItems()).containsExactly(new LineItem(
															Drink.CAPPUCCINO,
															Milk.SKIMMED,
															Size.SMALL,
															1));
		
		assertThat(order.getStatus()).isEqualTo(Status.PAYMENT_EXPECTED);
	}

	@Test
	public void baristaCanStartPreparingTheOrderWhenItIsPaid() {

		Order existingOrder = orders.save(aPaidOrder());

		Order orderInPreparation = barista.startPreparingOrder(existingOrder.getId());

		assertThat(orderInPreparation.getStatus()).isEqualTo(Status.PREPARING);
	}
}
