package com.farhad.example.dddorderexample.domain.model;

import com.farhad.example.dddorderexample.domain.shared.ValueObject;

import lombok.NonNull;
import lombok.Value;

@Value
public class CustomerId implements ValueObject<CustomerId> {


    @NonNull
    private String id;

    @Override
    public boolean sameValueAs(CustomerId other) {
        return this.equals(other);
    }

    public static CustomerId of(String id) {
        return new CustomerId(id);
    }

}
