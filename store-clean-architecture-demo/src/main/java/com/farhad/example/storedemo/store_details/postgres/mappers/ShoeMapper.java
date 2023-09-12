package com.farhad.example.storedemo.store_details.postgres.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.farhad.example.storedemo.store_core.money.Money;
import com.farhad.example.storedemo.store_core.produtcs.Shoe;
import com.farhad.example.storedemo.store_core.produtcs.ShoeId;

public class ShoeMapper implements RowMapper<Shoe> {

	@Override
	public Shoe mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Shoe(
				ShoeId.from(rs.getString("id")), 
				rs.getString("name"), 
				rs.getString("description"), 
				new Money(
					rs.getString("price_currency"), 
					rs.getBigDecimal("price_amount")));
	}
	
}
