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
public class ArticleTitle {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String slug;

    static ArticleTitle of(String title) {
        return new ArticleTitle(title, slugFromTitle(title));
    }

    private static String slugFromTitle(String title) {
        return title;
    }
}
