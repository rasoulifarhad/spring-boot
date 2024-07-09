package com.farhad.example.realworld_demo.domain.article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

}
