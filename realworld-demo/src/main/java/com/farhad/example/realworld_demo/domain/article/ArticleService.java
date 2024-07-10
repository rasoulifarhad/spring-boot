package com.farhad.example.realworld_demo.domain.article;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.farhad.example.realworld_demo.domain.article.tag.TagService;
import com.farhad.example.realworld_demo.domain.user.UserFindService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService implements ArticleFindService {

    private final ArticleRepository articleRepository;
    private final UserFindService userFindService;
    private final TagService tagService;


    @Override
    public Optional<Article> getArticleBySlug(String slug) {
        return null;
    }

}
