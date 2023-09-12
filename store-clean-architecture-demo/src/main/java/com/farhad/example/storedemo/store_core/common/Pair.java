package com.farhad.example.storedemo.store_core.common;

import lombok.Value;

@Value 
public class Pair<L, R> {
	private L left;
	private R right;
}