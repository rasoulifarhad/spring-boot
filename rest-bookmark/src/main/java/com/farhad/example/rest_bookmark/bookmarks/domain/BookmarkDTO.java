package com.farhad.example.rest_bookmark.bookmarks.domain;

import java.time.Instant;

import lombok.Value;

@Value
public class BookmarkDTO {
	private Long id;
	private String title;
	private String url;
	private Instant createdAt;
}
