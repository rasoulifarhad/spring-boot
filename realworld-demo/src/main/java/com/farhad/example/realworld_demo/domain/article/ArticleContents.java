package com.farhad.example.realworld_demo.domain.article;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Embeddable
public class ArticleContents {

    @Embedded
    private ArticleTitle articleTitle;

    @Embedded
    private ArticleDescription articleDescription;

    @Embedded
    private ArticleBody articleBody;

    @JoinTable(name = "articles_tags",
        joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false) )
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Setter
    private Set<Tag> tags = new HashSet<>();
}
