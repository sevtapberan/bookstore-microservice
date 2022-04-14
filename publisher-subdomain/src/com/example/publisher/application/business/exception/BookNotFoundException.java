package com.example.publisher.application.business.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {
	
	private final String identity;

	public BookNotFoundException(String message,String identity) {
		super(message);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}
	
	
	
	

}
