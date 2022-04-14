package com.example.publisher.service;

import java.util.List;

import com.example.publisher.domain.Publisher;
import com.example.publisher.domain.RequisitionId;
import com.example.publisher.dto.request.RequisitionApproveRequest;
import com.example.publisher.dto.response.GetBookResponse;
import com.example.publisher.dto.response.RequisitionApproveResponse;
import com.example.publisher.dto.response.RequisitionCancelResponse;

public interface PublisherService {
	
	List<Publisher> listAllBookByRequisition(Publisher publisher);
	
	GetBookResponse findOneBookByIsbn(String isbn);
	
	RequisitionApproveResponse  bookRequisitionApproveByPublisher(RequisitionApproveRequest request);
	
	RequisitionCancelResponse  bookRequisitionCancelByPublisher(RequisitionId requisitionId);
	

}
