package com.farhad.example.jpa_specification_criteria_api_demo.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost_center")
    private String costCenter;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department(String name, String costCenter) {
        this.name = name;
        this.costCenter = costCenter;
    }


}
