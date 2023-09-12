package com.farhad.example.storedemo.store_details.postgres;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.farhad.example.storedemo.store_core.orders.Order;
import com.farhad.example.storedemo.store_core.orders.OrderLineItem;
import com.farhad.example.storedemo.store_core.orders.OrderRepository;
import com.farhad.example.storedemo.store_core.security.PrincipalUser;
import com.farhad.example.storedemo.store_details.postgres.mappers.OrderMapper;
import com.farhad.example.storedemo.store_details.postgres.mappers.OrderMapper.LineItemMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class H2OrderRepository implements OrderRepository {

	private final JdbcTemplate jdbcTemplate;

	private OrderMapper orderMapper = new OrderMapper(); 
	private LineItemMapper lineItemMapper = new LineItemMapper();

	@Override
	public void submitOrder(Order order) {
		log.info("Persisting order {} -> {}", order, order.getPrice());
		order.getItems().forEach(o -> log.info("{} at {} each. Serials are: {}",
												o.getSku(), o.getPricePer(),o.getInventoryItems()));		
		jdbcTemplate.update(
			"insert into orders (id, user_name, user_email, time_placed, total_price_currency, total_price_amount) values (?, ?, ?, ?, ?, ?);", 
			order.getId().getValue(),
			order.getUser().getName(),
			order.getUser().getEmail(),
			Timestamp.from(order.getTime()),
			order.getPrice().getCurrency().getCurrencyCode(),
			order.getPrice().getAmount());

			jdbcTemplate.batchUpdate("insert into order_line_items (order_id, position, sku, price_per_currency, price_per_amount, serial_numbers) values (?, ?, ?, ?, ?);",
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						OrderLineItem lineItem = order.getItems().get(i);
						String[] serials = lineItem.getInventoryItems().stream().map(in -> in.getSerialNumber()).toArray(String[]::new);
						ps.setString(1, order.getId().getValue());
						ps.setInt(2, i);
						ps.setString(3, lineItem.getSku().getValue());
						ps.setString(4, lineItem.getPricePer().getCurrency().getCurrencyCode());
						ps.setBigDecimal(5, lineItem.getPricePer().getAmount());
						ps.setArray(6, jdbcTemplate.getDataSource().getConnection().createArrayOf("text", serials));
						
					}

					@Override
					public int getBatchSize() {
						return order.getItems().size();
					}
				
			})	;		
	}

	@Override
	public List<Order> listOrdersForUser(PrincipalUser user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'listOrdersForUser'");
	}

	@Override
	public void removeAllOrders() {
		jdbcTemplate.update("delete from order_line_items;");
		jdbcTemplate.update("delete from order;");
	}
	
}
