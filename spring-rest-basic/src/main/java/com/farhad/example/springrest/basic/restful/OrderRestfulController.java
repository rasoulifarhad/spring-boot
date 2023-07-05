package com.farhad.example.springrest.basic.restful;

import static com.farhad.example.springrest.basic.model.Status.CANCELED;
import static com.farhad.example.springrest.basic.model.Status.COMPLETED;
import static com.farhad.example.springrest.basic.model.Status.IN_PROGRESS;
import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springrest.basic.model.Order;
import com.farhad.example.springrest.basic.model.OrderNotFoundException;
import com.farhad.example.springrest.basic.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

// All the controller methods return one of Spring HATEOAS’s RepresentationModel subclasses to properly render hypermedia 
/**
 * Modeling the flow of order states between Status.IN_PROGRESS, Status.COMPLETED, and Status.CANCELLED.
 * 
 * A natural thing when serving up such data to clients is to let the clients make the decision on what it can do based on this payload.
 * 
 * But that would be wrong.
 * 
 * What happens when you introduce a new state in this flow? The placement of various buttons on the UI would probably be erroneous.
 * What if you changed the name of each state, perhaps while coding international support and showing locale-specific text for each state? That 
 * would most likely break all the clients.
 * 
 * Enter HATEOAS or Hypermedia as the Engine of Application State. 
 * 
 * Instead of clients parsing the payload, give them links to signal valid actions. Decouple state-based actions from the payload of data.
 * 
 * In other words, when CANCEL and COMPLETE are valid actions, dynamically add them to the list of links. Clients only need show users the 
 * corresponding buttons when the links exist.
 * 
 * This decouples clients from having to know WHEN such actions are valid, reducing the risk of the server and its clients getting out of 
 * sync on the logic of state transitions.
 * 
 *  Putting such logic in the OrderModelAssembler would be the perfect place to capture this business rule.
 */
@RequiredArgsConstructor
@RestController
public class OrderRestfulController {
    
    private final OrderRepository repository;
    private final OrderModelAssembler assembler;

    @GetMapping("/v2/orders")
    CollectionModel<EntityModel<Order>> all() {
        List<EntityModel<Order>> orders = repository.findAll()
                                                .stream()
                                                .map(assembler::toModel)
                                                .collect(toList());
        return CollectionModel.of(orders,linkTo(methodOn(OrderRestfulController.class).all()).withSelfRel());
    }

    @GetMapping("/v2/orders/{id}")
    EntityModel<Order> byId(@PathVariable Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        return assembler.toModel(order);
    }

    @PostMapping("/v2/orders")
    ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order) {
        order.setStatus(IN_PROGRESS);
        Order newOrder = repository.save(order);
        
        return ResponseEntity
                    .created(linkTo(methodOn(OrderRestfulController.class).byId(newOrder.getId())).toUri())
                    .body(assembler.toModel(newOrder));
    }

    @DeleteMapping("/v2/orders/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        Order order = repository.findById(id)
                        .orElseThrow(() -> new OrderNotFoundException(id));
        if (order.getStatus() == IN_PROGRESS) {
            order.setStatus(CANCELED);
            return ResponseEntity.ok(assembler.toModel(repository.save(order)));
        }
        return ResponseEntity
                    .status(HttpStatus.METHOD_NOT_ALLOWED)
                    .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                    .body(Problem.create()
                            .withTitle("Method not allowed")
                            .withDetail("You can not cancel an order that is in the " + order.getStatus() + " status."));
                            
    }

    @PutMapping("/v2/orders/{id}/complete")
    public ResponseEntity<?> complete(@PathVariable Long id) {
        Order order = repository.findById(id)
                        .orElseThrow(() -> new OrderNotFoundException(id));
        if (order.getStatus() == IN_PROGRESS) {
            order.setStatus(COMPLETED);
            return ResponseEntity.ok(assembler.toModel(repository.save(order)));
        }
        return ResponseEntity
                    .status(HttpStatus.METHOD_NOT_ALLOWED)
                    .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                    .body(Problem.create()
                            .withTitle("Method not allowed")
                            .withDetail("You can not complete an order that is in " + order.getStatus() + " status"));
    }

}
