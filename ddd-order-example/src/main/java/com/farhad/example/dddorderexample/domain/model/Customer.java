package com.farhad.example.dddorderexample.domain.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
public class Customer {

    @Embeddable
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class CustomerId implements Serializable {

        @NonNull
        @Getter
        private String value;

        public static CustomerId of(String id) {
            return new CustomerId(id);
        }

    }

}
