package com.farhad.example.petclinic.domain.port.outgoing;

import java.util.List;
import java.util.Optional;

import com.farhad.example.petclinic.domain.model.pet.Pet;

public interface PetRepository {
    List<Pet> getAll();

    Optional<Pet> get(Long id);

    Long add(Pet pet);

}
