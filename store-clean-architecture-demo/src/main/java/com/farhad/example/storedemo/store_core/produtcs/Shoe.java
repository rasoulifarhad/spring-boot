package com.farhad.example.storedemo.store_core.produtcs;

import com.farhad.example.storedemo.store_core.money.Money;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shoe {
	private ShoeId id;
	private String name;
	private String description;
	private Money price;

}
