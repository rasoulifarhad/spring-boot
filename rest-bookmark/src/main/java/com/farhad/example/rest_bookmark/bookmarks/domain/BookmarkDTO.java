package com.farhad.example.rest_bookmark.bookmarks.domain;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookmarkDTO {
	private Long id;
	private String title;
	private String url;
	private Instant createdAt;

	public static BookmarkDTO from(Bookmark bookmark) {
		return new BookmarkDTO(
			bookmark.getId(), 
			bookmark.getTitle(), 
			bookmark.getUrl(), 
			bookmark.getCreatedAt());
	}
}
