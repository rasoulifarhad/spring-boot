package com.farhad.example.discount.application;

public class DiscounterTest {

	private Discounter app = new Discounter(RepositoryFactory.getMockRateRepository());
	private  Double amount;

	public Double discount() {
		return app.discount(amount);
	}
}
