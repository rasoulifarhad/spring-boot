package com.farhad.example.petclinic.domain.model.customer;

import java.util.List;

import com.farhad.example.petclinic.domain.model.pet.Pet;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

	private Long id;

	private String firstname;
	private String lastname;
	private List<Pet> pets;
	
	public Customer(String firstname, String lastname, List<Pet> pets) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.pets = pets;
	}
	
}
