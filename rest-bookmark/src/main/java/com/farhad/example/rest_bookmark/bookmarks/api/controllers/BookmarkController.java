package com.farhad.example.rest_bookmark.bookmarks.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkDTO;
import com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkService;
import com.farhad.example.rest_bookmark.bookmarks.domain.FindBookmarkQuery;
import com.farhad.example.rest_bookmark.bookmarks.domain.PagedResult;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
class BookmarkController {
	private final BookmarkService bookmarkService;
	
	@GetMapping
	public PagedResult<BookmarkDTO> findBookmarks(
			@RequestParam(name = "page", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "size", defaultValue = "10") Integer pageSize) {

		FindBookmarkQuery query = new FindBookmarkQuery(pageNo, pageSize);
		return bookmarkService.findBookmarks(query);
	}
}
