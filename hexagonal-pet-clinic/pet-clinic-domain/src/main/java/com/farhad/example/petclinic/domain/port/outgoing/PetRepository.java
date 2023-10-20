package com.farhad.example.petclinic.domain.port.outgoing;

import java.util.List;

import com.farhad.example.petclinic.domain.model.pet.Pet;

public interface PetRepository {
    List<Pet> getAll();

    Pet get(long id);

    void add(Pet pet);

}
