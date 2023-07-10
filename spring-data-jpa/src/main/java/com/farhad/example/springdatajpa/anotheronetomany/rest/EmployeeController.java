package com.farhad.example.springdatajpa.anotheronetomany.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springdatajpa.anotheronetomany.dto.EmployeeDto;
import com.farhad.example.springdatajpa.anotheronetomany.dto.LeaveDto;
import com.farhad.example.springdatajpa.anotheronetomany.service.EmployeeService;
import com.farhad.example.springdatajpa.anotheronetomany.service.LeaveService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EmployeeController {
    
    private final EmployeeService service;
    private final LeaveService leaveService;

    @GetMapping("/employees")
    public List<EmployeeDto> all() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}/leaves")
    public List<LeaveDto> getEmployeeLeaves(@PathVariable long id) {

        return leaveService.getEmployeeLeaves(id);
    }

}
