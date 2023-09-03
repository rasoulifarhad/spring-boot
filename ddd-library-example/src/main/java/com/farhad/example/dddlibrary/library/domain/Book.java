package com.farhad.example.dddlibrary.library.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book {
	
	private int bookId;
	private boolean borrowed;
	private boolean readingRoomOnly;

	public boolean canBeBorrowed() {
		return !borrowed && !readingRoomOnly;
	}
}
