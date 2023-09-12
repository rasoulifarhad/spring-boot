package com.farhad.example.storedemo.store_details.postgres.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.farhad.example.storedemo.store_core.produtcs.ShoeId;
import com.farhad.example.storedemo.store_core.variants.ProductVariant;
import com.farhad.example.storedemo.store_core.variants.Sku;
import com.farhad.example.storedemo.store_core.variants.VariantColor;
import com.farhad.example.storedemo.store_core.variants.VariantSize;

public class ProductVariantMappers implements RowMapper<ProductVariant> {

	@Override
	public ProductVariant mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProductVariant(
			new Sku(rs.getString("sku")), 
			ShoeId.from(rs.getString("shoe_id")), 
			rs.getString("label"), 
			VariantSize.lookup(rs.getString("size")).get(), 
			VariantColor.lookup(rs.getString("color")).get());
	}
	
}
