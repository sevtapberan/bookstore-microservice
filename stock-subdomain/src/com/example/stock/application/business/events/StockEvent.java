package com.example.stock.application.business.events;

import java.util.UUID;

public class StockEvent {
	private final String eventId;
	
	public StockEvent() {
		this.eventId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return eventId;
	}

	
}
