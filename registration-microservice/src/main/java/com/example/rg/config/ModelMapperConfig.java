package com.example.rg.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;


import com.example.registration.domain.Customer;
import com.example.rg.document.CustomerDocument;
import com.example.rg.dto.request.CreateCustomerRequest;
import com.example.rg.dto.response.CreateCustomerResponse;
import com.example.rg.dto.response.DeleteCustomerResponse;



public class ModelMapperConfig {
	
	
	private static final Converter<Customer, CreateCustomerResponse>
	CUSTOMER_TO_CREATE_CUSTOMER_RESPONSE_CONVERTER = 
	(context) -> {
		var customer = context.getSource();
		var fullname = customer.getFullName();
		var response = new CreateCustomerResponse();
		response.setTcKimlikNo(customer.getTcKimlikNo().getValue());
		response.setFullname(String.format("%s %s", 
				fullname.getFirst(),fullname.getLast()));
		return response;
	};
	
	
	private static final Converter<Customer, DeleteCustomerResponse>
	CUSTOMER_TO_DELETE_CUSTOMER_RESPONSE_CONVERTER = 
	(context) -> {
		var customer = context.getSource();
		var fullname = customer.getFullName();
		var response = new DeleteCustomerResponse();
		response.setTcKimlikNo(customer.getTcKimlikNo().getValue());
		response.setFullname(String.format("%s %s", 
				fullname.getFirst(),fullname.getLast()));
		
		response.setSalary(customer.getSalary().getValue());
	
		response.setBirthYear(customer.getBirthYear().getValue());
		return response;
	};
	
	private static final Converter<Customer, CustomerDocument>
	CUSTOMER_TO_CUSTOMER_DOCUMENT_CONVERTER = 
	(context) -> {
		var customer = context.getSource();
		var fullname = customer.getFullName();
		var cusDoc = new CustomerDocument();
		cusDoc.setTcKimlikNo(customer.getTcKimlikNo().getValue());
		cusDoc.setFullName(String.format("%s %s", 
				fullname.getFirst(),fullname.getLast()));
		cusDoc.setSalary(customer.getSalary().getValue());
        cusDoc.setBirthYear(customer.getBirthYear().getValue());
	     return cusDoc;
	};
	
	
	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(CUSTOMER_TO_CUSTOMER_DOCUMENT_CONVERTER, 
				Customer.class, CustomerDocument.class);
		
			mapper.addConverter(CUSTOMER_TO_DELETE_CUSTOMER_RESPONSE_CONVERTER, 
				Customer.class, DeleteCustomerResponse.class);
		mapper.addConverter(CUSTOMER_TO_CREATE_CUSTOMER_RESPONSE_CONVERTER, 
				Customer.class, CreateCustomerResponse.class);
		return mapper;
	}
	
	

}
