package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.farhad.example.coffeeorder.application.order.LineItem;
import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.shared.Drink;
import com.farhad.example.coffeeorder.shared.Location;
import com.farhad.example.coffeeorder.shared.Milk;
import com.farhad.example.coffeeorder.shared.Size;

@PersistenceTest
public class OrdersJpaAdapterTest {

	@Autowired
	private Orders orders;

	@Autowired
	private OrderJpaRepository orderJpaRepository;

	@Test
	void creatingOrderReturnsPersistedOrder() {
		Order order = new Order(
			Location.TAKE_AWAY, 
			Arrays.asList(
				new LineItem(
					Drink.LATTE, 
					Milk.WHOLE, 
					Size.SMALL, 
					1)));
		Order persistedOrder = orders.save(order);

		assertThat(persistedOrder.getLocation()).isEqualTo(Location.TAKE_AWAY);
		assertThat(persistedOrder.getItems()).containsExactly(
										new LineItem(
													Drink.LATTE,
													Milk.WHOLE,
													Size.SMALL,
													1));		
	}


    @Test
    void findingPreviouslyPersistedOrderReturnsDetails() {
    }

    @Test
    void findingNonExistingOrderThrowsException() {
    }

    @Test
    @Sql("classpath:data/order.sql")
    void deletesPreviouslyPersistedOrder() {
    }	
}
