package com.farhad.example.dddorderexample.infra.persistence.jpa;

import com.farhad.example.dddorderexample.domain.model.Order;
import com.farhad.example.dddorderexample.domain.model.Order.OrderId;
import com.farhad.example.dddorderexample.domain.shared.BaseRepository;

public interface OrderEntityRepository extends BaseRepository<Order, OrderId> {

}
