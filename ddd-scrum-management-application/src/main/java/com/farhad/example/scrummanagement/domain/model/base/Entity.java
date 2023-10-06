package com.farhad.example.scrummanagement.domain.model.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
@Data
public abstract class Entity {
    
    @EqualsAndHashCode.Include
    @Id
    private Long id;
}
