package com.farhad.example.coffeeorder.application.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.farhad.example.coffeeorder.shared.Location;
import com.farhad.example.coffeeorder.shared.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Order {
	
	private UUID id = UUID.randomUUID();

	private final Location location;

	private final List<LineItem> items;

	private Status status = Status.PAYMENT_EXPECTED;

    public boolean canBeCancelled() {
        return status == Status.PAYMENT_EXPECTED;
    }
	
    public BigDecimal getCost() {
        return 
			items.stream()
				.map(LineItem::getCost)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
    }	

	public Order markPaid() {
		if(status != Status.PAYMENT_EXPECTED) {
			throw new IllegalStateException("Order is Already paid");
		}
		status = Status.PAID;
		return this;
	}

	public Order markBeingPrepared() {
		if(status != Status.PAID) {
			throw new IllegalStateException("Order is not paid");
		}
		status = Status.PREPARING;
		return this;
	}

	public Order markPrepared() {
		if(status != Status.PREPARING) {
			throw new IllegalStateException("Order is not being prepared");
		}
		status = Status.READY;
		return this;
	}

	public Order markTaken() {
		if(status != Status.READY) {
			throw new IllegalStateException("Order is not ready");
		}
		status = Status.TAKEN;
		return this;
	}

}
