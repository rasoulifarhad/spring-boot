package com.farhad.example.dddorderexample.infra.persistence.jpa;

import com.farhad.example.dddorderexample.domain.model.Order.OrderId;
import com.farhad.example.dddorderexample.domain.shared.BaseAggregateRoot;

import jakarta.persistence.Entity;

@Entity
public class OrderEntity extends BaseAggregateRoot<OrderId> {

}
