package com.example.bookcatalog.application.business.exceptions;

@SuppressWarnings("serial")
public class ExistingBookException extends RuntimeException {
	private final String identity;

	public ExistingBookException(String message, String identity) {
		super(message);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}
}
