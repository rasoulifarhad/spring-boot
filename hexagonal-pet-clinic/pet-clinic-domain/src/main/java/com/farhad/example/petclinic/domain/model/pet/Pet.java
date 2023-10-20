package com.farhad.example.petclinic.domain.model.pet;

import static java.util.Objects.requireNonNull;

import com.farhad.example.petclinic.domain.model.customer.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pet {
	
	private Long id;

	private String name;
	private Customer owner;
	
	public Pet(String name) {
		this.name = requireNonNull(name);
	}

	
}
