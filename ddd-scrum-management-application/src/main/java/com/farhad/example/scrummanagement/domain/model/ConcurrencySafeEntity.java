package com.farhad.example.scrummanagement.domain.model;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class ConcurrencySafeEntity extends Entity {

    private Long version;
}
