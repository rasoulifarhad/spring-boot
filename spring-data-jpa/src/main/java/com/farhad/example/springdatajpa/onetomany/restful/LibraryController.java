package com.farhad.example.springdatajpa.onetomany.restful;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.springdatajpa.onetomany.LibraryNotFoundException;
import com.farhad.example.springdatajpa.onetomany.model.Library;
import com.farhad.example.springdatajpa.onetomany.repository.LibraryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LibraryController {
    
    private final LibraryRepository repository;

    @GetMapping("/v2/libraries")
    public List<Library> all() {
        return repository.findAll();
    }

    @PostMapping("/v2/libraries")
    public Library newLibrary(@RequestBody Library library) {
        return repository.save(library);
    }

    // Link includes a URI and a rel (relation).
    // 
    // linkTo(methodOn(LibraryController.class).byId(id)).withSelfRel() asks that Spring HATEOAS build a link to the LibraryController 's byId() 
    // method, and flag it as a self link.
    // 
    // linkTo(methodOn(LibraryController.class).all()).withRel("libraries") asks Spring HATEOAS to build a link to the aggregate root, all(), 
    // and call it "libraries".
    @GetMapping(value="/v2/libraries/{id}")
    public EntityModel<Library> byId(@PathVariable Long id) {
        Library library = repository.findById(id).orElseThrow(() -> new LibraryNotFoundException(id));
        return EntityModel.of(
            library,
            linkTo(methodOn(LibraryController.class).byId(id)).withSelfRel(),
            linkTo(methodOn(LibraryController.class).all()).withRel("libraries")
        );
    }

    @PutMapping("/v2/libraries/{id}")
    public Library replaceLibrary(@RequestBody Library newLibrary, @PathVariable Long id) {
        return repository.findById(id)
                    .map(library -> {
                        library.setName(newLibrary.getName());
                        library.setAddress(newLibrary.getAddress() != null ? newLibrary.getAddress() : library.getAddress());
                        return repository.save(library);
                    })
                    .orElseGet(() -> {
                        newLibrary.setId(id);
                        return repository.save(newLibrary);
                    });
    }

    @DeleteMapping("/v2/libraries/{id}") 
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}
