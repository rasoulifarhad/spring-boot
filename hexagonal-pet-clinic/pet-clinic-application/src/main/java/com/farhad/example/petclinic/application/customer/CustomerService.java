package com.farhad.example.petclinic.application.customer;

import java.util.List;

import com.farhad.example.petclinic.application.pet.PetService;
import com.farhad.example.petclinic.domain.model.customer.Customer;
import com.farhad.example.petclinic.domain.model.pet.Pet;
import com.farhad.example.petclinic.domain.port.incoming.CustomerUseCase;
import com.farhad.example.petclinic.domain.port.outgoing.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {
	
	private final CustomerRepository customerRepository;
	private final PetService petService; 

	@Override
	public Customer get(long id) {
		return customerRepository.get(id)
					.orElse(null);
					
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.getAll();
	}

	@Override
	public void add(Customer customer) {
		for (Pet pet : customer.getPets()) {
			petService.add(pet);
		}
		customerRepository.add(customer);
	}
}
