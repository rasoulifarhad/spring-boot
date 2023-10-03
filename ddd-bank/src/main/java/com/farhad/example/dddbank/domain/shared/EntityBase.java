package com.farhad.example.dddbank.domain.shared;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@MappedSuperclass
public abstract class EntityBase<T extends EntityBase<T>> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    public boolean sameIdentityAs(final T that) {
        return this.equals(that);
    }
}
