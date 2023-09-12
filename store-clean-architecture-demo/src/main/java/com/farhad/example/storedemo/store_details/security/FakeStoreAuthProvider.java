package com.farhad.example.storedemo.store_details.security;

import com.farhad.example.storedemo.store_core.security.PrincipalUser;
import com.farhad.example.storedemo.store_core.security.StoreAuthProvider;

// Simulate real security and just spit out some user. In reality this class would be something like
// "AuthZeroStoreAuthProvider" or something similar.
public class FakeStoreAuthProvider implements StoreAuthProvider {

	private PrincipalUser currentUser;

	@Override
	public PrincipalUser getCurrentUser() {
		if (currentUser == null) {
			throw new RuntimeException("No logged in user");
		}
		return currentUser;
	}
	
	// For testing purposes, login some user for testing
	public void login(PrincipalUser user) {
		this.currentUser = user;
	}
}
