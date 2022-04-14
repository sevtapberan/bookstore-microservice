package com.example.registration.application.business.exception;

@SuppressWarnings("serial")
public class ExistingCustomerException extends RuntimeException {

	private final String identity;

	public ExistingCustomerException(String message, String identity) {
		super(message);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}
	
}