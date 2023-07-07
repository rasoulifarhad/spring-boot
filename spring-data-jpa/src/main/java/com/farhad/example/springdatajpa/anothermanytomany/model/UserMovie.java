package com.farhad.example.springdatajpa.anothermanytomany.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users_movies")
public class UserMovie {
    
    @EmbeddedId
    private UserMovieId id = new UserMovieId();

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("movieId")
    private Movie movie;

    @Column(nullable = false)
    private int rate;

    private String review;

    // @CreationTimestamp
    // @Column(name =  "added_at", nullable = false)
    // private Instant addedAt;
    
    public UserMovie(UserMovieId id, int rate, String review) {
        this.id = id;
        this.rate = rate;
        this.review = review;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class UserMovieId implements Serializable {
        
        private static final long serialVersionUID = 1L;
        private Long userId;
        private Long movieId;

    }
}
