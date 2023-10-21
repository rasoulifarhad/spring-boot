package com.farhad.example.petclinic.api.customer;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.petclinic.api.customer.dto.CustomerDto;
import com.farhad.example.petclinic.application.customer.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerConrtoller {
	

    private final CustomerService customerService;

	@GetMapping("/{id}")
    public CustomerDto get(@PathVariable Long id) {
        return CustomerDto.fromDomain(customerService.get(id));
    }


	@GetMapping
    public List<CustomerDto> getAll() {
        return customerService.getAll()
								.stream()
								.map(CustomerDto::fromDomain)
								.collect(toList());
    }

	@PostMapping
    public void add(@RequestBody CustomerDto customer) {
        customerService.add(customer.toDomain());
    }	
}
