package com.farhad.example.dddorderexample.infra.persistence.jpa;

import org.springframework.data.jpa.domain.Specification;

import com.farhad.example.dddorderexample.domain.model.Order;
import com.farhad.example.dddorderexample.domain.model.Order_;

import jakarta.validation.constraints.NotNull;

public class OrderSpecifications {

    public @NotNull Specification<Order> byOrderNo(@NotNull String orderNo) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.like(root.get(Order_.orderNo), orderNo);
    }

}
