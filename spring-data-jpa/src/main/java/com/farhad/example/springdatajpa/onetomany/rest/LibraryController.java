package com.farhad.example.springdatajpa.onetomany.rest;

import java.util.List;

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

    @GetMapping("/libraries")
    public List<Library> all() {
        return repository.findAll();
    }

    @PostMapping("/libraries")
    public Library newLibrary(@RequestBody Library library) {
        return repository.save(library);
    }

    @GetMapping(value="/libraries/{id}")
    public Library byId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new LibraryNotFoundException(id));
    }

    @PutMapping("/libraries/{id}")
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

    @DeleteMapping("/libraries/{id}") 
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
}
