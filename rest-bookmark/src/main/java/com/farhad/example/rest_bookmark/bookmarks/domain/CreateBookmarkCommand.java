package com.farhad.example.rest_bookmark.bookmarks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

// Should we send CreateBookmarkRequest as input to BookmarkService.create(…) method? Or, create BookmarkDTO object from CreateBookmarkRequest 
// and then send it to BookmarkService.create(…) method?

// My preference is to create a new CreateBookmarkCommand class with title and url properties and send it to BookmarkService.create(…) method. 
// This may seem unnecessary because CreateBookmarkRequest and CreateBookmarkCommand are exactly same in this scenario.

// But imagine this API endpoint can only be invoked by an authenticated user. Then we may need to include createdBy property in the input to 
// BookmarkService.create(…) method which is not available in CreateBookmarkRequest. So, to keep each layer’s responsibilities separate, I would 
// use a separate command object.
@Data
@AllArgsConstructor
public class CreateBookmarkCommand {
	private String title;
	private String url;
}
