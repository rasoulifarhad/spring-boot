package com.farhad.example.petclinic.domain.port.incoming;

import java.util.List;

import com.farhad.example.petclinic.domain.model.pet.Pet;

public interface PetUseCase {
	List<Pet> getAllPet();
	void add(Pet pet);
	
	
}
