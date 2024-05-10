package com.farhad.example.dddorderexample.domain.model;

import java.math.BigDecimal;

import com.farhad.example.dddorderexample.domain.shared.specification.AbstractSpecification;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class OrderAmountSpecification extends AbstractSpecification<Order> {

    @NonNull
    private final BigDecimal amount;

    @Override
    public boolean isSatisfiedBy(Order t) {
        return amount.compareTo(t.getMonetaryValue().getAmount() ) < 0;
    }

}
