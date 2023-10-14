package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.entity;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.shared.Location;
import com.farhad.example.coffeeorder.shared.Status;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderEntity {
	
	@Id
	@GeneratedValue
	private UUID id;

	@Enumerated
	@NotNull
	private Location location;

	@Enumerated
	@NotNull
	private Status status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<LineItemEntity> items;

	public Order toDomain() {
		return new Order(
			id, 
			location, 
			items.stream().map(LineItemEntity::toDomain).collect(toList()), 
			status);
	}

	public static OrderEntity fromDomain(Order order) {
		OrderEntity e = new OrderEntity();
		e.setId(order.getId());
		e.setLocation(order.getLocation());
		e.setStatus(order.getStatus());
		e.setItems(order.getItems().stream().map(LineItemEntity::fromDomain).collect(toList()));
		return e;
	}
}
