package com.farhad.example.discount.application;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Discounter {

	private final RateRepository rateRepository;
	public Double discount(Double amount) {
		double rate = rateRepository.getRate(amount);
		return amount * rate;
	}
	
}
