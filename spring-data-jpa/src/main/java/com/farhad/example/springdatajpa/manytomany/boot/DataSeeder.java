package com.farhad.example.springdatajpa.manytomany.boot;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.farhad.example.springdatajpa.manytomany.model.Movie;
import com.farhad.example.springdatajpa.manytomany.model.Users;
import com.farhad.example.springdatajpa.manytomany.repository.MovieRepository;
import com.farhad.example.springdatajpa.manytomany.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private final UsersRepository usersRepository;
    private final MovieRepository movieRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Movie movie1 = Movie.builder()
                                .name("Movie 1")
                                .description("Movie 1 description")
                                .relaseDate(LocalDate.of(2020, Month.APRIL, 12))
                                .build();
        Movie movie2 = Movie.builder()
                                .name("Movie 2")
                                .description("Movie 2 description")
                                .relaseDate(LocalDate.of(2021, Month.JULY, 1))
                                .build();
        Movie createdMovie1 = movieRepository.save(movie1);
        Movie createdMovie2 = movieRepository.save(movie2);

        Users user = Users.builder()
                            .username("John")
                            .password("john_password")
                            .email("jhon@example.com")
                            .build();
        Set<Movie> movies = new HashSet<>();
        movies.add(createdMovie1);
        movies.add(createdMovie2);
        user.getLikedMovies().addAll(movies);
        // user.setLikedMovies(movies);
        Users createdUser = usersRepository.save(user);

        createdUser.getLikedMovies().forEach(m -> System.out.println(m));
    }
    
}
