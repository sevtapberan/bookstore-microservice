package com.example.registration.application.business.exception;

@SuppressWarnings("serial")

public class CustomerNotFoundException extends RuntimeException{
	
	private final String identity;

	public CustomerNotFoundException(String message, String identity) {
		
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
