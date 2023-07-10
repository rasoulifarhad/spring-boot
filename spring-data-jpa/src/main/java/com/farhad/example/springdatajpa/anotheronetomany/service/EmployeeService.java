package com.farhad.example.springdatajpa.anotheronetomany.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.farhad.example.springdatajpa.anotheronetomany.dto.EmployeeDto;
import com.farhad.example.springdatajpa.anotheronetomany.model.Employee;
import com.farhad.example.springdatajpa.anotheronetomany.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
    
    private final EmployeeRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public List<EmployeeDto> getAllEmployees() {
        log.info("Retrieving list of employees");
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private EmployeeDto convertToDto(Employee employee) {
        return this.mapper.map(employee, EmployeeDto.class);
    }

}
