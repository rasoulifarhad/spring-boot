package com.farhad.example.articles.domain.model;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
public class PersonName {
	
	private final String firstName;
	private final String lastName; 

	public String getName() {
		return firstName + " " + lastName;
	}

}
