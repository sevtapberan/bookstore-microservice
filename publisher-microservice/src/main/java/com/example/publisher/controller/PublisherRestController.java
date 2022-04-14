package com.example.publisher.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.publisher.domain.RequisitionId;
import com.example.publisher.dto.request.RequisitionApproveRequest;
import com.example.publisher.dto.response.GetBookResponse;
import com.example.publisher.dto.response.RequisitionApproveResponse;
import com.example.publisher.dto.response.RequisitionCancelResponse;
import com.example.publisher.service.PublisherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestScope
@RequestMapping("publishers")
@CrossOrigin
@Validated
@Api( tags = "Publishers")
public class PublisherRestController {
	
	private PublisherService publisherService;

	public PublisherRestController(PublisherService publisherService) {
		this.publisherService = publisherService;
 	}
	
	@GetMapping("{isbn}")
	@ApiOperation(value = "This method is used to get the book for the given {isbn}")
	public GetBookResponse findOneBookByIsbn(@PathVariable String isbn) {
		return publisherService.findOneBookByIsbn(isbn);
	}
	
	@PostMapping
	RequisitionApproveResponse  bookRequisitionApproveByPublisher(@RequestBody @Validated RequisitionApproveRequest request) {
		return publisherService.bookRequisitionApproveByPublisher(request);
	}
	
	@DeleteMapping("requisitionId")
	public RequisitionCancelResponse  bookRequisitionCancelByPublisher(@PathVariable RequisitionId requisitionId) {
		return publisherService.bookRequisitionCancelByPublisher(requisitionId);
	}
	
	
	

}
