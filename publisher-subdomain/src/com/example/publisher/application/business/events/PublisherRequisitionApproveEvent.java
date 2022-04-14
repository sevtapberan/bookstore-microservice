package com.example.publisher.application.business.events;

import com.example.publisher.domain.Publisher;

public class PublisherRequisitionApproveEvent extends PublisherEvent{

	private final Publisher publisher;

	public PublisherRequisitionApproveEvent(Publisher publisher) {
		this.publisher = publisher;
	}

	public Publisher getPublisher() {
		return publisher;
	}
}
