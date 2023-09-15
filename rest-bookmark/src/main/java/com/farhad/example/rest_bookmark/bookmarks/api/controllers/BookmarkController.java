package com.farhad.example.rest_bookmark.bookmarks.api.controllers;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.farhad.example.rest_bookmark.bookmarks.api.models.CreateBookmarkRequest;
import com.farhad.example.rest_bookmark.bookmarks.api.models.UpdateBookmarkRequest;
import com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkDTO;
import com.farhad.example.rest_bookmark.bookmarks.domain.BookmarkService;
import com.farhad.example.rest_bookmark.bookmarks.domain.CreateBookmarkCommand;
import com.farhad.example.rest_bookmark.bookmarks.domain.FindBookmarkQuery;
import com.farhad.example.rest_bookmark.bookmarks.domain.PagedResult;
import com.farhad.example.rest_bookmark.bookmarks.domain.UpdateBookmarkCommand;

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

	// should we return BookmarkDTO or ResponseEntity<BookmarkDTO>?
	//
    // I would prefer to use ResponseEntity as return type if:
	//
	// - I need to send different HTTP Status Codes for different kinds of failures or validation errors.
	// - I need to add headers.
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	ResponseEntity<BookmarkDTO> create(@RequestBody @Validated CreateBookmarkRequest request) {
		CreateBookmarkCommand cmd = new CreateBookmarkCommand(request.getTitle(), request.getUrl());
		BookmarkDTO bookmark = bookmarkService.create(cmd);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/api/bookmarks/{id}")
						.buildAndExpand(bookmark.getId()).toUri();
		return ResponseEntity.created(location).body(bookmark);
	}

	@PutMapping("{/id}")
	public void update(@PathVariable(name = "id") Long id,
			@RequestBody @Validated UpdateBookmarkRequest request) {
		UpdateBookmarkCommand cmd = new UpdateBookmarkCommand(id, request.getTitle(), request.getUrl());
		bookmarkService.update(cmd);
	}
}
