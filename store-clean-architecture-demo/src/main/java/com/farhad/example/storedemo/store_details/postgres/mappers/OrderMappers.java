package com.farhad.example.storedemo.store_details.postgres.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.farhad.example.storedemo.store_core.money.Money;
import com.farhad.example.storedemo.store_core.orders.Order;
import com.farhad.example.storedemo.store_core.orders.OrderId;
import com.farhad.example.storedemo.store_core.security.PrincipalUser;
import com.farhad.example.storedemo.store_core.variants.Sku;

import lombok.AllArgsConstructor;
import lombok.Data;

public class OrderMappers implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Order(
						OrderId.from(rs.getString("id")), 
						new PrincipalUser(rs.getString("user_name"), rs.getString("user_email")), 
						rs.getTimestamp("time_placed").toInstant());
	}
	
	@Data
	@AllArgsConstructor
	public static class LineItemRow {
		private OrderId orderId;
		private Integer position;
		private Sku sku;
		private Money pricePer;
		private List<String> serialNumbers;
	}

	public static class LineItemMapper implements RowMapper<LineItemRow> {

		@Override
		public LineItemRow mapRow(ResultSet rs, int rowNum) throws SQLException {
			String [] serialArray = (String []) rs.getArray("serial_numbers").getArray();
			return new LineItemRow(
				OrderId.from(rs.getString("order_id")), 
				rs.getInt("position"), 
				new Sku(rs.getString("sku")), 
				new Money(rs.getString("price_per_currency"), rs.getBigDecimal("price_per_amount")), 
				Arrays.asList(serialArray));
		}

	}
}
