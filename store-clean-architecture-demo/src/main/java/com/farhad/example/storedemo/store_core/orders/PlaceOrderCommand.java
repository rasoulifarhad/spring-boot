package com.farhad.example.storedemo.store_core.orders;

import java.util.List;

import com.farhad.example.storedemo.store_core.common.Pair;
import com.farhad.example.storedemo.store_core.security.PrincipalUser;
import com.farhad.example.storedemo.store_core.variants.Sku;

import lombok.Value;

@Value
public class PlaceOrderCommand {
	
	private final PrincipalUser user;
	private final List<Pair<Sku, Integer>> items;
}
