package com.farhad.example.springdatajpa.onetomany;

import java.util.Objects;

import lombok.Getter;

@Getter
public class LibraryNotFoundException extends RuntimeException {
    private final Long id;

    public LibraryNotFoundException(Long id) {
        super("Could not find library " + id);
        Objects.requireNonNull(id);
        this.id = id;
    }
}
