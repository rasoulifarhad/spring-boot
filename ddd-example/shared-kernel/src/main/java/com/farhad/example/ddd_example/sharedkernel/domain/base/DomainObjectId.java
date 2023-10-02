package com.farhad.example.ddd_example.sharedkernel.domain.base;

import static java.util.Objects.requireNonNull;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__({@JsonCreator}))
@Data
public abstract class DomainObjectId implements ValueObject {

    @NonNull
    @Getter(onMethod = @__({@JsonValue, @org.springframework.lang.NonNull}))
    private final String uuid;
    
    public static <ID extends DomainObjectId> ID randomId(Class<ID> idClazz) {
        requireNonNull(idClazz);
        try {
            return idClazz
                .getConstructor(String.class)
                    .newInstance(UUID.randomUUID().toString());
        } catch (Exception e) {
            throw new RuntimeException("Could not create new instance of " + idClazz, e);
        }
    }
}
