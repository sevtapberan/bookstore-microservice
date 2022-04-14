package com.example.publisher.adapter;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.example.publisher.document.PublisherDocument;
import com.example.publisher.domain.Isbn;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.RequisitionId;
import com.example.publisher.repository.PublisherDocumentMongoRepository;
import com.example.publisher.repository.PublisherRepository;

public class PublisherRepositoryMongoAdapter implements PublisherRepository{
	
	private PublisherDocumentMongoRepository mongoRepository;
	private ModelMapper modelMapper;
	
	
	
	public PublisherRepositoryMongoAdapter(PublisherDocumentMongoRepository mongoRepository, ModelMapper modelMapper) {
		this.mongoRepository = mongoRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Optional<Publisher> findOneByIsbn(Isbn isbn) {
		return mongoRepository.findById(isbn.getValue())
							  .map(isb -> modelMapper.map(isb, Publisher.class));
	}
	@Override
	public Publisher approveRequisition(Publisher publisher) {
		var document = modelMapper.map(publisher, PublisherDocument.class);
		return modelMapper.map(mongoRepository.save(document), Publisher.class);
	}
	@Override
	public Optional<Publisher> removeRequisition(RequisitionId requisitionId) {
		var document =  mongoRepository.findById(requisitionId.getValue());
		document.ifPresent(mongoRepository::delete);
		return document.map(req -> modelMapper.map(req, Publisher.class));
	}

	@Override
	public List<Publisher> findAllByRequisition(Publisher publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

	

}
