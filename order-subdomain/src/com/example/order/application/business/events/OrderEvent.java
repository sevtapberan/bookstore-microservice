package com.example.order.application.business.events;

import java.util.UUID;

public class OrderEvent {
	private final String eventId;

	public OrderEvent() {
		this.eventId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return eventId;
	}
}
