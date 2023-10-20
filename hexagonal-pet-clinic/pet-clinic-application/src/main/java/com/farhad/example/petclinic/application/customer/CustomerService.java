package com.farhad.example.petclinic.application.customer;

import java.util.List;

import com.farhad.example.petclinic.application.pet.PetService;
import com.farhad.example.petclinic.domain.model.customer.Customer;
import com.farhad.example.petclinic.domain.port.incoming.CustomerUseCase;
import com.farhad.example.petclinic.domain.port.outgoing.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerService implements CustomerUseCase {
	
	private final CustomerRepository customerRepository;
	private final PetService petService; 

	@Override
	public Customer get(long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'get'");
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAll'");
	}

	@Override
	public void add(Customer customer) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}
}
