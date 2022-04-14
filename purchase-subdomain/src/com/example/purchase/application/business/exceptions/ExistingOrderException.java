package com.example.purchase.application.business.exceptions;

@SuppressWarnings("serial")
public class ExistingOrderException extends RuntimeException {
	private final String identity;

	public ExistingOrderException(String message, String identity) {
		super(message);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}
}
