package com.farhad.example.rest_bookmark.bookmarks.api.models;

import javax.validation.constraints.NotEmpty;

import lombok.Value;

@Value
public class UpdateBookmarkRequest {
	@NotEmpty(message = "Title is required")
	private String title;
	@NotEmpty(message = "Url is required")
	private String url;
}
