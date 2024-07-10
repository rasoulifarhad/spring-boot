package com.farhad.example.realworld_demo.domain.article;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode

public class ArticleDescription {

    @Column(nullable = false)
    private String description;

    static ArticleDescription of(String description) {
        return new ArticleDescription(description);
    }
}
