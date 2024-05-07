package com.farhad.example.dddhibernatedemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farhad.example.dddhibernatedemo.domain.Order;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("""
        select o from order o
        left join fetch o.orderItems oi
        left join fetch oi.product
        left join fetch o.shippingAddress
        where o.customerId = :customerId
        """)
    Order findByCustomerIdCustomQuery(@Param("customerId") Long customerId) ;

    @Query(nativeQuery = true, value = """
            select o.* from order 
            where o.customerId = : customerId
            """)
    Order findByCustomerIdNativeQuery(@Param("customerId") Long customerId) ;
}
