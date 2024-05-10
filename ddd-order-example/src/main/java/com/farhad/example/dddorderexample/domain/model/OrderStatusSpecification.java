package com.farhad.example.dddorderexample.domain.model;

import com.farhad.example.dddorderexample.domain.shared.specification.AbstractSpecification;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class OrderStatusSpecification extends AbstractSpecification<Order> {

    @NonNull
    private final Order.Status status;

    @Override
    public boolean isSatisfiedBy(Order t) {
        return status.equals(t.getStatus());
    }

}
