package com.farhad.example.springdatajpa.anotheronetomany.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @Builder.Default private List<Leave> leaves = new ArrayList<>();

    public Employee addLeave(Leave leave) {
        this.leaves.add(leave);
        leave.setEmployee(this);
        return this;
    }
}
