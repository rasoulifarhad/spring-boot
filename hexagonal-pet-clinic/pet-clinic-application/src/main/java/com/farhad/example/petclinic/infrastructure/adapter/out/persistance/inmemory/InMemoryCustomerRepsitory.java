package com.farhad.example.petclinic.infrastructure.adapter.out.persistance.inmemory;

import java.util.List;
import java.util.Optional;

import com.farhad.example.petclinic.domain.model.customer.Customer;
import com.farhad.example.petclinic.domain.port.outgoing.CustomerRepository;

public class InMemoryCustomerRepsitory extends InMemoryRepository<Customer> implements CustomerRepository{

	@Override
	public Long add(Customer entity) {
		return super.add(entity);
	}

	@Override
	public Optional<Customer> get(Long id) {
		return super.get(id);
	}

	@Override
	public List<Customer> getAll() {
		return super.getAll();
	}

	
}
