package com.farhad.example.articles.adapters.apis;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ArticleRequest {

    private final String authorId;
    private final String title;
    private final String content;
	
}
