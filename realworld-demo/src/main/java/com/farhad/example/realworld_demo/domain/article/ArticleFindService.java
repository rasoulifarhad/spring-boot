package com.farhad.example.realworld_demo.domain.article;

import java.util.Optional;

public interface ArticleFindService {

    Optional<Article> getArticleBySlug(String slug);
}
