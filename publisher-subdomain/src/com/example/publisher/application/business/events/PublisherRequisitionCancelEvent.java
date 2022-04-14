package com.example.publisher.application.business.events;

import com.example.publisher.domain.Publisher;

public class PublisherRequisitionCancelEvent extends PublisherEvent {
	private final Publisher publisher;

	public PublisherRequisitionCancelEvent(Publisher publisher) {
		this.publisher = publisher;
	}

	public Publisher getPublisher() {
		return publisher;
	}

}
