package com.farhad.example.jpa_specification_criteria_api_demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.farhad.example.jpa_specification_criteria_api_demo.domain.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long>{

}
