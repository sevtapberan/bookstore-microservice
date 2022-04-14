package com.example.rg.service.business;

import org.modelmapper.ModelMapper;


import com.example.registration.application.CustomerApplication;
import com.example.registration.domain.Customer;
import com.example.registration.domain.TcKimlikNo;
import com.example.rg.dto.request.CreateCustomerRequest;
import com.example.rg.dto.response.CreateCustomerResponse;
import com.example.rg.dto.response.DeleteCustomerResponse;
import com.example.rg.service.RegistrationService;

public class StandardRegistrationService implements RegistrationService{
	
	private CustomerApplication customerApplication;
	private ModelMapper modelMapper;
	
	

	public StandardRegistrationService(CustomerApplication customerApplication, ModelMapper modelMapper) {
		super();
		this.customerApplication = customerApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
		var customer = modelMapper.map(request, Customer.class);
		var createdCustomer = customerApplication.createCustomer(customer);
		return modelMapper.map(createdCustomer, CreateCustomerResponse.class);
	}

	@Override
	public DeleteCustomerResponse deleteCustomer(String kimlikNo) {
		var customer = customerApplication.deleteCustomer(TcKimlikNo.valueOf(kimlikNo));
		return modelMapper.map(customer, DeleteCustomerResponse.class);
	}

}
