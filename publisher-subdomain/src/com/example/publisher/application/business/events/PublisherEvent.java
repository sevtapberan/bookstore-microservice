package com.example.publisher.application.business.events;

import java.util.UUID;

public class PublisherEvent {
	private final String eventId;

	public PublisherEvent() {
		this.eventId = UUID.randomUUID().toString();
	}

	public String getEventId() {
		return eventId;
	}
	
	
	
	

}
