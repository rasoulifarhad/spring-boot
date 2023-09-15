package com.farhad.example.rest_bookmark.bookmarks.domain;

public class BookmarkNotFpundException extends RuntimeException {
	public BookmarkNotFpundException(Long id) {
		super(String.format("Bookmark with id=%d not found", id));
	}

	public static BookmarkNotFpundException of(Long id) {
		return new BookmarkNotFpundException(id);
	}
}
