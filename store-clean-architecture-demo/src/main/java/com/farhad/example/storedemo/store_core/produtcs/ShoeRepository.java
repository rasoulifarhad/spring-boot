package com.farhad.example.storedemo.store_core.produtcs;

import java.util.List;
import java.util.Optional;

import com.farhad.example.storedemo.store_core.money.Money;

public interface ShoeRepository {
	Optional<Shoe> findById(ShoeId id);
	List<Shoe> list();
	List<Shoe> findByName(String namePartial);
	List<Shoe> findByPriceUnder(Money upperPrice);
}
