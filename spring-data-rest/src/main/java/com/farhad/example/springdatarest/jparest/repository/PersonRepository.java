package com.farhad.example.springdatarest.jparest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.farhad.example.springdatarest.jparest.model.Person;

// At runtime, Spring Data REST automatically creates an implementation of this interface. Then it uses the @RepositoryRestResource annotation 
// to direct Spring MVC to create RESTful endpoints at /people.
// @RepositoryRestResource is not required for a repository to be exported. It is used only to change the export details, such as using /people 
// instead of the default value of /persons.
//
// Spring Data REST builds on top of Spring MVC. It creates a collection of Spring MVC controllers, JSON converters, and other beans to 
// provide a RESTful front end. 
//
// If you want to investigate how that works, by looking at the RepositoryRestMvcConfiguration in Spring Data REST.
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);
}
