package com.farhad.example.petclinic.infrastructure.adapter.out.persistance.inmemory;

import java.util.List;
import java.util.Optional;

import com.farhad.example.petclinic.domain.model.pet.Pet;
import com.farhad.example.petclinic.domain.port.outgoing.PetRepository;

public class InMemoryPetRepsitory extends InMemoryRepository<Pet> implements PetRepository {

	@Override
	public Long add(Pet entity) {
		return super.add(entity);
	}

	@Override
	public Optional<Pet> get(Long id) {
		return super.get(id);
	}

	@Override
	public List<Pet> getAll() {
		return super.getAll();
	}

	
}
