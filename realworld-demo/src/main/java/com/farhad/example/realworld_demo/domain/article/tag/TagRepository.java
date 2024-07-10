package com.farhad.example.realworld_demo.domain.article.tag;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface TagRepository extends Repository<Tag, Long> {

    List<Tag> findAll();
    Optional<Tag> findFirstByValue(String value);
}
