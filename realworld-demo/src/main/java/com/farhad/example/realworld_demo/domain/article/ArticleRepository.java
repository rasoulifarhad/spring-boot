package com.farhad.example.realworld_demo.domain.article;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.farhad.example.realworld_demo.domain.article.tag.Tag;
import com.farhad.example.realworld_demo.domain.user.User;
import com.farhad.example.realworld_demo.domain.user.UserName;

public interface ArticleRepository extends Repository<Article, Long> {

    Article save(Article article);
    Page<Article> findAll(Pageable pageable);
    Page<Article> findAllByUserFavoritedContains(User user, Pageable pageable);
    Page<Article> findAllByAuthorProfileUserName(UserName authorName, Pageable pageable);
    Page<Article> findAllByContentsTagsContains(Tag tag, Pageable pageable);
    Optional<Article> findFirstByContentsTitleSlug(String slug);

    void deleteArticleByAuthorAndContentsTitleSlug(User author, String slug);
}
