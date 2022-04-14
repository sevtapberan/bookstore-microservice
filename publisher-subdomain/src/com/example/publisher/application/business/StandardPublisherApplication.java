package com.example.publisher.application.business;

import java.util.List;
import java.util.Optional;

import com.example.publisher.application.PublisherApplication;
import com.example.publisher.application.business.events.BookRequisitionEvent;
import com.example.publisher.application.business.events.PublisherRequisitionApproveEvent;
import com.example.publisher.application.business.events.PublisherRequisitionCancelEvent;
import com.example.publisher.application.business.exception.BookNotFoundException;
import com.example.publisher.domain.Isbn;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.RequisitionId;
import com.example.publisher.infrastructure.EventPublisher;
import com.example.publisher.repository.PublisherRepository;

public class StandardPublisherApplication implements PublisherApplication{
	
	private PublisherRepository publisherRepository;
	private EventPublisher eventPublisher;
	
	
	public StandardPublisherApplication(PublisherRepository publisherRepository, EventPublisher eventPublisher) {
		
		this.publisherRepository = publisherRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public List<Publisher> listAllBookByRequisition(Publisher publisher) {
		List<Publisher> listRequisition = publisherRepository.findAllByRequisition(publisher);
		eventPublisher.publishEvent(new BookRequisitionEvent(listRequisition));
		return listRequisition;
	}

	@Override
	public Optional<Publisher> findOneBookByIsbn(Isbn isbn) {
		return publisherRepository.findOneByIsbn(isbn);
	}

	@Override
	public Publisher bookRequisitionApproveByPublisher(Publisher publisher) {
		Publisher approveRequisition = publisherRepository.approveRequisition(publisher);
		var businessEvent = new PublisherRequisitionApproveEvent(approveRequisition);
		eventPublisher.publishEvent(businessEvent);
		return approveRequisition;
	}

	@Override
	public Publisher bookRequisitionCancelByPublisher(RequisitionId requisitionId) {
		Optional<Publisher> removedRequisition = publisherRepository.removeRequisition(requisitionId);
		var cancel = removedRequisition.orElseThrow(() -> new BookNotFoundException(
				"There is not like this a request",requisitionId.getValue()));
		eventPublisher.publishEvent(new PublisherRequisitionCancelEvent(cancel));
		return cancel;
	}

}
