package com.farhad.example.rest_bookmark.bookmarks.domain;

import lombok.Value;

@Value
public class FindBookmarkQuery {
	private int pageNo;
	private int pageSize;
}
