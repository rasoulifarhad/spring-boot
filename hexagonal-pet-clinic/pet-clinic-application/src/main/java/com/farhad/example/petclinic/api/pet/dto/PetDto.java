package com.farhad.example.petclinic.api.pet.dto;

import com.farhad.example.petclinic.domain.model.pet.Pet;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class PetDto {
	
	private String name;

	public Pet toDomain() {
		return new Pet(name);
	}

	public static PetDto fromDomain(Pet pet) {
		return new PetDto(pet.getName());
	}
}
