package com.farhad.example.storedemo.store_details.postgres;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.farhad.example.storedemo.store_core.produtcs.ShoeId;
import com.farhad.example.storedemo.store_core.variants.ProductVariant;
import com.farhad.example.storedemo.store_core.variants.ProductVariantRepository;
import com.farhad.example.storedemo.store_core.variants.Sku;
import com.farhad.example.storedemo.store_details.postgres.mappers.ProductVariantMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class H2ProductVariantRepository implements ProductVariantRepository {

	private final JdbcTemplate jdbcTemplate;
	private ProductVariantMapper productVariantMapper = new ProductVariantMapper();

	@Override
	public List<ProductVariant> findAllVariantForShoe(ShoeId id) {
		return jdbcTemplate.query(
			"select * from variants where shoe_id = ?;", 
			productVariantMapper, 
			id.getValue());
	}

	@Override
	public Optional<ProductVariant> findById(Sku sku) {
		return Optional.ofNullable(jdbcTemplate.queryForObject(
			"select * from variants where sku = ?  limit 1;", 
			productVariantMapper, 
			sku.getValue()));
	}

	@Override
	public void registerNewVariants(List<ProductVariant> variants) {
		jdbcTemplate.batchUpdate(
			"insert into variants (sku, shoe_id, label, size, color) values (?, ?, ?, ?, ?)", 
			new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ProductVariant variant = variants.get(i);
					ps.setString(1, variant.getSku().getValue());
					ps.setString(2, variant.getShoeId().getValue());
					ps.setString(3, variant.getLabel());
					ps.setString(4, variant.getSize().toString());
					ps.setString(5, variant.getColor().toString());
				}

				@Override
				public int getBatchSize() {
					return variants.size();
				}
				
			});
	}
	
}
