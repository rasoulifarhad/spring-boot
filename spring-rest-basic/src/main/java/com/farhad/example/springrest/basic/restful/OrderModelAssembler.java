package com.farhad.example.springrest.basic.restful;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.farhad.example.springrest.basic.model.Order;
import com.farhad.example.springrest.basic.model.Status;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {
        // unconditional links
        EntityModel<Order> orderModel = EntityModel.of(
                            order,
                            linkTo(methodOn(OrderRestfulController.class).byId(order.getId())).withSelfRel(),
                            linkTo(methodOn(OrderRestfulController.class).all()).withRel("orders"));
        // Conditional Links based on state of the order
        if (order.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(OrderRestfulController.class).cancel(order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrderRestfulController.class).complete(order.getId())).withRel("complete"));
        }
        return orderModel;
    }
    
}
