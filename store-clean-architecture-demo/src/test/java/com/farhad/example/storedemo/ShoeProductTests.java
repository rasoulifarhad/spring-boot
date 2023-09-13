package com.farhad.example.storedemo;

import org.junit.Test;

import com.farhad.example.storedemo.store_app.http.api.shoes.ShoeResults;

public class ShoeProductTests extends BaseIntegrationTest {
	
	@Test
	public void contextLoads() {

	}

	@Test
	public void given_noQueryParams_when_query_then_returnAll() {
		ShoeResults results = restTemplate.getForObject(String.format("http://localhost:%d/shoes",serverPort).toString(), 
												ShoeResults.class);
		
	}
}
