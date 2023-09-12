package com.farhad.example.storedemo.store_details.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;

import com.farhad.example.storedemo.store_core.money.Money;
import com.farhad.example.storedemo.store_core.produtcs.Shoe;
import com.farhad.example.storedemo.store_core.produtcs.ShoeId;
import com.farhad.example.storedemo.store_core.produtcs.ShoeRepository;
import com.farhad.example.storedemo.store_details.postgres.mappers.ShoeMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class H2ShoeRepository implements ShoeRepository {

	private final JdbcTemplate jdbcTemplate;

	private ShoeMapper shoeMapper = new ShoeMapper();
	@Override
	public Optional<Shoe> findById(ShoeId id) {
		return Optional.ofNullable(jdbcTemplate.queryForObject("select * from shoes where id = ? limit 1;", 
																	shoeMapper, 
																	id.getValue()));
	}

	@Override
	public List<Shoe> list() {
		return jdbcTemplate.query("select * from shoes;", shoeMapper);
	}

	@Override
	public List<Shoe> findByName(String namePartial) {
		return jdbcTemplate.query("select * from shoes where name like ? ", shoeMapper, String.format("%%%s%%", namePartial));
	}

	@Override
	public List<Shoe> findByPriceUnder(Money upperPrice) {
		return jdbcTemplate.query("select * from shoes where price_amount <= ?", shoeMapper,upperPrice.getAmount());
	}
	
}
