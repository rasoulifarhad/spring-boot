package com.farhad.example.petclinic.api.pet;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.petclinic.api.pet.dto.PetDto;
import com.farhad.example.petclinic.application.pet.PetService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pets")
public class PetController {
	
    private final PetService petService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<PetDto> getAll() {
        return petService.getAllPet()
					.stream()
					.map(PetDto::fromDomain)
					.collect(toList());
    }	
}
