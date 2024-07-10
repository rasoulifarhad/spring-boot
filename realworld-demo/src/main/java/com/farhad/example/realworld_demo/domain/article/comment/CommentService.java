package com.farhad.example.realworld_demo.domain.article.comment;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.farhad.example.realworld_demo.domain.article.ArticleFindService;
import com.farhad.example.realworld_demo.domain.user.UserFindService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserFindService userFindService;
    private final ArticleFindService articleFindService;

    public Comment createComment(long userId, String slug, String body) {
        return null;
    }


    public Set<Comment> getComments(long userId, String slug) {
        return new HashSet<>();
    }

    public Set<Comment> getComments(String slug) {
        return new HashSet<>();
    }

    public void deleteCommentById(long userId, String slug, long commentId) {
    }
}
