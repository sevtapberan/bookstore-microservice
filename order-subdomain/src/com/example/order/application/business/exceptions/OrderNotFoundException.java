package com.example.order.application.business.exceptions;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {
	private final String identity;

	public OrderNotFoundException(String message, String identity) {
		super(message);
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
