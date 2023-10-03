package com.farhad.example.scrummanagement.domain.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class Entity {
    

    @Id
    private Long id;
}
