package com.farhad.example.realworld_demo.domain.article;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.farhad.example.realworld_demo.domain.article.comment.Comment;
import com.farhad.example.realworld_demo.domain.user.User;

import lombok.Getter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "articles")
@Getter
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private User author;
    @Embedded
    private ArticleContents contents;

    @Column(name = "created_at")
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;
    
    @JoinTable(name = "article_favorites",
        joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false))
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<User> usersFavorited = new HashSet<>();

    @OneToMany(mappedBy = "article", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Comment> comments = new HashSet<>();

    public Article(User author, ArticleContents contents) {
        this.author = author;
        this.contents = contents;
    }

    protected Article() {
    }


    public int getFavoritedCount() {
        return usersFavorited.size();
    }
}
