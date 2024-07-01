package com.farhad.example.dddrealworld.domain.article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ArticleId id;

    
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @Value
    public static class ArticleId {
    
        private Long value;

        public static ArticleId of(long id ) {
            return new ArticleId(id);
        }
    

    }

}
