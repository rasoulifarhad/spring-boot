package com.farhad.example.springdatajpa.anotheronetomany.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.farhad.example.springdatajpa.anotheronetomany.dto.LeaveDto;
import com.farhad.example.springdatajpa.anotheronetomany.model.Leave;
import com.farhad.example.springdatajpa.anotheronetomany.repository.LeaveRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LeaveService {
    
    private final LeaveRepository repository;
    private ModelMapper mapper = new ModelMapper();

    @Transactional(readOnly = true)
    public List<LeaveDto> getEmployeeLeaves(Long employeeId) {
        return repository.findByEmployeeId(employeeId).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private LeaveDto convertToDto(Leave leave) {
        return this.mapper.map(leave, LeaveDto.class);
    }

}
