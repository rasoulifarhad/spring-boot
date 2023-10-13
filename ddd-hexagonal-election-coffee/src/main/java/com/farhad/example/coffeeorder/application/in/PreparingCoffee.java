package com.farhad.example.coffeeorder.application.in;

import java.util.UUID;

public interface PreparingCoffee {
	
	Order startPreparingOrder(UUID orderId);
	Order finishPreparingOrder(UUID orderId);
}
