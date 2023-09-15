package com.farhad.example.rest_bookmark.bookmarks.api.models;

import javax.validation.constraints.NotEmpty;

import lombok.Value;

// When I look at the request payload, I have a bunch of questions:
//
// - Should I generate the id from client side and send it in the payload, or it will be generated on the server-side?
// - If I include the id in the request payload, does it override the bookmark details if an entity wth same id value exist or 
//   ignore the id and creates a new bookmark?
// - Should I include createdAt or server will use the timestamp of the record insertion into DB?
// - What if I set a future date for createdAt?
// 
// All these questions came up because we are not explicit in our contract.
// 
// The actual API behaviour we want is, the client should only send the title and url. Then we will automatically generate the id and 
// use the current timestamp as createdAt value.
// 
// To avoid the confusion and bring more clarity to what is the expected payload, it is better to create a request class for this 
// specific API endpoint as follows.

@Value
public class CreateBookmarkRequest {
	@NotEmpty(message = "Title is required")
	private String title;
	@NotEmpty(message = "Url is required")
	private String url;
}
