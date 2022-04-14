package com.example.bookcatalog.application.business.exceptions;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {
	private final String identity;

	public BookNotFoundException(String message, String identity) {
		super(message);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}
}
