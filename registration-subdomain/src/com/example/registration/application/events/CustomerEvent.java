package com.example.registration.application.events;

import java.util.UUID;

public class CustomerEvent {
	
	private final String eventId;

	public CustomerEvent() {
		this.eventId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return eventId;
	}

}
