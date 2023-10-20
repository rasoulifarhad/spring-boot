package com.farhad.example.petclinic.application.pet;

import java.util.List;

import com.farhad.example.petclinic.domain.model.pet.Pet;
import com.farhad.example.petclinic.domain.port.incoming.PetUseCase;
import com.farhad.example.petclinic.domain.port.outgoing.PetRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetService implements PetUseCase {

	private final PetRepository petRepository;

	@Override
	public List<Pet> getAllPet() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAllPet'");
	}

	@Override
	public void add(Pet pet) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}
	
}
