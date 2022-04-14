package com.example.publisher.service.business;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.publisher.application.PublisherApplication;
import com.example.publisher.application.business.exception.BookNotFoundException;
import com.example.publisher.domain.Isbn;
import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.RequisitionId;
import com.example.publisher.dto.request.RequisitionApproveRequest;
import com.example.publisher.dto.response.GetBookResponse;
import com.example.publisher.dto.response.RequisitionApproveResponse;
import com.example.publisher.dto.response.RequisitionCancelResponse;
import com.example.publisher.service.PublisherService;

@Service
public class StandardPublisherService implements PublisherService {
	private PublisherApplication publisherApplication;
	private ModelMapper modelMapper;
	

	public StandardPublisherService(PublisherApplication publisherApplication, ModelMapper modelMapper) {
		
		this.publisherApplication = publisherApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<Publisher> listAllBookByRequisition(Publisher publisher) {
		List<Publisher> listBook = publisherApplication.listAllBookByRequisition(publisher);
		return listBook;
	}

	@Override
	public GetBookResponse findOneBookByIsbn(String isbn) {
		var publisher = publisherApplication.findOneBookByIsbn(Isbn.of(isbn));
		if (publisher.isEmpty())
			throw new BookNotFoundException("Cannot find book", isbn);
		return modelMapper.map(publisher.get(), GetBookResponse.class);
	}

	@Override
	public RequisitionApproveResponse bookRequisitionApproveByPublisher(RequisitionApproveRequest request) {
		var publisher = modelMapper.map(request, Publisher.class);
		var requisitionApprove = publisherApplication.bookRequisitionApproveByPublisher(publisher);
		return modelMapper.map(requisitionApprove, RequisitionApproveResponse.class);
	}

	@Override
	public RequisitionCancelResponse bookRequisitionCancelByPublisher(RequisitionId requisitionId) {
		var publisher = publisherApplication.bookRequisitionCancelByPublisher(requisitionId);
		return modelMapper.map(publisher, RequisitionCancelResponse.class);
	}

}
