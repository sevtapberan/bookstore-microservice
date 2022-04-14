package com.example.publisher.application;

import java.util.List;
import java.util.Optional;

import com.example.publisher.domain.Isbn;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.RequisitionId;

public interface PublisherApplication {
	
	List<Publisher> listAllBookByRequisition(Publisher publisher);
	
	Optional<Publisher> findOneBookByIsbn(Isbn isbn);
	
	Publisher  bookRequisitionApproveByPublisher(Publisher publisher);
	
	Publisher  bookRequisitionCancelByPublisher(RequisitionId requisitionId);
	
	
	

}
