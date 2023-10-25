package com.farhad.example.discount.application;

public class RepositoryFactory {
	
	public static RateRepository getMockRateRepository(){
		return new MockRateRepository();
	}
}
