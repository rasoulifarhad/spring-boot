package com.farhad.example.newsfeed.domain;

import lombok.Data;

@Data
public class NewsItem {
    private String title;
    private String snippet;
    private String url;
    private Source source;
}
