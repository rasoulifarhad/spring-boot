package com.farhad.example.dddorderexample.domain.shared;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.annotation.Nullable;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BaseEntity<Id extends Serializable> extends AbstractPersistable<Id> {

    @Version
    private Long version;

    public @NotNull Optional<Long> getVertion() {
        return Optional.ofNullable(version);
    }

    protected void setVertion(@Nullable Long version) {
        this.version = version;
    }
}
