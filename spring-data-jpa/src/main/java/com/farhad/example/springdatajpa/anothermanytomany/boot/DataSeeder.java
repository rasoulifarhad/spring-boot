package com.farhad.example.springdatajpa.anothermanytomany.boot;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.farhad.example.springdatajpa.anothermanytomany.model.Movie;
import com.farhad.example.springdatajpa.anothermanytomany.model.User;
import com.farhad.example.springdatajpa.anothermanytomany.model.UserMovie;
import com.farhad.example.springdatajpa.anothermanytomany.model.UserMovie.UserMovieId;
import com.farhad.example.springdatajpa.anothermanytomany.repository.MovieRepository;
import com.farhad.example.springdatajpa.anothermanytomany.repository.UserMovieRepository;
import com.farhad.example.springdatajpa.anothermanytomany.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final UserMovieRepository userMovieRepository; 
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

        User user = User.builder()
                            .name("John")
                            .email("jhon@example.com")
                            .build();
        User createdUser = userRepository.save(user);

        UserMovieId userMovieId1 = new UserMovieId(createdUser.getId(), createdMovie1.getId());
        UserMovie userMovie1 =  new UserMovie(userMovieId1, 4, " this is good moview");
        userMovie1.setUser(createdUser);
        userMovie1.setMovie(createdMovie1);

        UserMovieId userMovieId2 = new UserMovieId(createdUser.getId(), createdMovie2.getId());
        UserMovie userMovie2 =  new UserMovie(userMovieId2, 5, " this is awesome moview");
        userMovie2.setUser(createdUser);
        userMovie2.setMovie(createdMovie2);

        userMovieRepository.save(userMovie1);
        userMovieRepository.save(userMovie2);

        Iterable<UserMovie>  userMovieList = userMovieRepository.findAll();

        System.out.println("==================================================================================================");
        userMovieList.forEach(userMovie -> System.out.println("The user " + userMovie.getUser().getName() + " gave a rate of " + userMovie.getRate() + " to the movie " + userMovie.getMovie().getName()));


    }
    
}
