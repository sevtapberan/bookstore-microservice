package com.example.publisher.application.business.events;

import java.util.List;

import com.example.publisher.domain.Publisher;

public class BookRequisitionEvent extends PublisherEvent{
	
	private final List<Publisher> publisher;

	public BookRequisitionEvent(List<Publisher> publisher) {
		this.publisher = publisher;
	}

	public List<Publisher> getPublisher() {
		return publisher;
	}

	
	
	
	

}
