package com.example.order.application.business.exceptions;


@SuppressWarnings("serial")
public class ExistingOrderException extends RuntimeException {
	private final String orderId;

	public ExistingOrderException(String message, String orderId) {
		super(message);
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}
	
}
