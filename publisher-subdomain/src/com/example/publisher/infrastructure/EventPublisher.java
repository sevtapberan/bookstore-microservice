package com.example.publisher.infrastructure;

import com.example.publisher.application.business.events.PublisherEvent;

public interface EventPublisher {

	void publishEvent(PublisherEvent businessEvent);

}
