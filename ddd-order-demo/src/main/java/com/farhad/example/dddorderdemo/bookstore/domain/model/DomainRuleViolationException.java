package com.farhad.example.dddorderdemo.bookstore.domain.model;

public class DomainRuleViolationException  extends RuntimeException {
	public DomainRuleViolationException(String message) {
		super(message);
	}
}
