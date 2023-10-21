package com.farhad.example.petclinic.api.customer.dto;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.farhad.example.petclinic.api.pet.dto.PetDto;
import com.farhad.example.petclinic.domain.model.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class CustomerDto {
	
    private String firstName;
	private String  lastName;
    private List<PetDto> pets;	

    public static CustomerDto fromDomain(Customer customer) {
        return new CustomerDto(
					customer.getFirstname(), 
					customer.getLastname(), 
					customer.getPets() != null 
						? customer.getPets()
									.stream()
									.map(PetDto::fromDomain)
									.collect(toList()) 
						: null);
    }

    public Customer toDomain() {
        return new Customer(
			firstName, 
			lastName, 
			pets != null 
				? pets.stream().map(PetDto::toDomain).collect(toList()) 
				: null);
    }	
}
