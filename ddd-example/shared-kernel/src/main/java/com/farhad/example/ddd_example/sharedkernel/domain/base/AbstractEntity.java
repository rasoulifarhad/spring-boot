package com.farhad.example.ddd_example.sharedkernel.domain.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public abstract class AbstractEntity<ID extends DomainObjectId> implements IdentifiableDomainObject<ID> {

    @Id
    @JsonProperty("id")
    private ID id;

    protected AbstractEntity(@NonNull AbstractEntity<ID> source) {
        this.id = source.id;
    }

    protected AbstractEntity(@NonNull ID id) {
        this.id = id;
    }

}
