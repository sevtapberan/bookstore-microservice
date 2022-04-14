package com.example.publisher.repository;

import java.util.List;
import java.util.Optional;

import com.example.publisher.domain.Isbn;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.RequisitionId;

public interface PublisherRepository {

	List<Publisher> findAllByRequisition(Publisher publisher);

	Optional<Publisher> findOneByIsbn(Isbn isbn);

	Publisher approveRequisition(Publisher publisher);//talepleri onaylamak

	Optional<Publisher> removeRequisition(RequisitionId requisitionId);

	

}
