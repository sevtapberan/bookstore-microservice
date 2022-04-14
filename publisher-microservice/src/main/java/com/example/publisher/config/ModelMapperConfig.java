package com.example.publisher.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.publisher.document.PublisherDocument;
import com.example.publisher.domain.Publisher;
import com.example.publisher.dto.request.RequisitionApproveRequest;
import com.example.publisher.dto.response.GetBookResponse;
import com.example.publisher.dto.response.RequisitionApproveResponse;
import com.example.publisher.dto.response.RequisitionCancelResponse;

@Configuration 
public class ModelMapperConfig {
	private static final Converter<Publisher, GetBookResponse>
    PUBLISHER_TO_GET_BOOK_RESPONSE_CONVERTER = 
(context) -> {
   var publisher = context.getSource();
   var response = new GetBookResponse();
   response.setPublisherId(publisher.getPublisherId().getValue());
   response.setPublisherName(publisher.getPublisherName().getName());
   response.setPublisherLogo(publisher.getPublisherLogo().getBase64Values());
   response.setRequisitionId(publisher.getRequisitionId().getValue());
   response.setIsbn(publisher.getIsbn().getValue());
   response.setAuthor(publisher.getAuthor().getAuthor());
  
   System.err.println("PUBLISHER_TO_GET_PUBLISHER_RESPONSE_CONVERTER: "+response);
   return response;
};
private static final Converter<Publisher, RequisitionCancelResponse>
PUBLISHER_TO_REQUISITION_CANCEL_RESPONSE_CONVERTER = 
(context) -> {
	   var publisher = context.getSource();
	   var response = new RequisitionCancelResponse();
	   response.setPublisherId(publisher.getPublisherId().getValue());
	   response.setPublisherName(publisher.getPublisherName().getName());
	   response.setPublisherLogo(publisher.getPublisherLogo().getBase64Values());
	   response.setRequisitionId(publisher.getRequisitionId().getValue());
	   response.setIsbn(publisher.getIsbn().getValue());
	   response.setAuthor(publisher.getAuthor().getAuthor());
	
	return response;
};

private static final Converter<Publisher, RequisitionApproveResponse>
PUBLISHER_TO_REQUISITION_APPROVE_RESPONSE_CONVERTER = 
(context) -> {
	   var publisher = context.getSource();
	   var response = new RequisitionApproveResponse();
	   response.setPublisherName(publisher.getPublisherName().getName());
	   response.setRequisitionId(publisher.getIsbn().getValue());
	   response.setRequisitionId(publisher.getRequisitionId().getValue());
	return response;
};

private static final Converter<RequisitionApproveRequest, Publisher>
REQUISITION_APPROVE_REQUEST_TO_PUBLISHER_CONVERTER = 
(context) -> {
	var request = context.getSource();
	return new Publisher.Builder()
			           .publisherName(request.getPublisherName())
			           .publisherLogo(request.getPublisherLogo())
			           .isbn(request.getIsbn())
			           .build();
};

private static final Converter<PublisherDocument, Publisher>
PUBLISHER_DOCUMENT_TO_PUBLISHER_CONVERTER = 
(context) -> {
	var document = context.getSource();
	return new Publisher.Builder()
			.publisherName(document.getPublisherName())
			.isbn(document.getIsbn())
			.publisherLogo(document.getPublisherLogo())
			.build();
};

private static final Converter<Publisher, PublisherDocument>
PUBLISHER_TO_PUBLISHER_DOCUMENT_CONVERTER = 
(context) -> {
	var publisher = context.getSource();
	var publisherDocument = new PublisherDocument();
	publisherDocument.setPublisherId(publisher.getPublisherId().getValue());
	   publisherDocument.setPublisherName(publisher.getPublisherName().getName());
	   publisherDocument.setPublisherLogo(publisher.getPublisherLogo().getBase64Values());
	   publisherDocument.setRequisitionId(publisher.getRequisitionId().getValue());
	   publisherDocument.setIsbn(publisher.getIsbn().getValue());
	   publisherDocument.setAuthor(publisher.getAuthor().getAuthor());
	   
	   return publisherDocument;
};

@Bean
public ModelMapper modelMapper() {
	var mapper = new ModelMapper();
	mapper.addConverter(PUBLISHER_TO_PUBLISHER_DOCUMENT_CONVERTER, 
			Publisher.class, PublisherDocument.class);
	mapper.addConverter(PUBLISHER_DOCUMENT_TO_PUBLISHER_CONVERTER, 
			PublisherDocument.class, Publisher.class);
	mapper.addConverter(PUBLISHER_TO_GET_BOOK_RESPONSE_CONVERTER, 
			Publisher.class, GetBookResponse.class);
	mapper.addConverter(PUBLISHER_TO_REQUISITION_CANCEL_RESPONSE_CONVERTER, 
			Publisher.class, RequisitionCancelResponse.class);
	mapper.addConverter(PUBLISHER_TO_REQUISITION_APPROVE_RESPONSE_CONVERTER, 
			Publisher.class, RequisitionApproveResponse.class);
	mapper.addConverter(REQUISITION_APPROVE_REQUEST_TO_PUBLISHER_CONVERTER, 
			RequisitionApproveRequest.class, Publisher.class);
	return mapper;
}

}
