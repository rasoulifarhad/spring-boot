package com.farhad.example.rest_bookmark.bookmarks.domain;

import lombok.Value;

@Value
public class UpdateBookmarkCommand {
	private Long id;
	private String title;
	private String url;
}
