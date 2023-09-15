package com.farhad.example.rest_bookmark.bookmarks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateBookmarkCommand {
	private Long id;
	private String title;
	private String url;
}
