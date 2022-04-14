package com.example.rg.service;

import com.example.rg.dto.request.CreateCustomerRequest;
import com.example.rg.dto.response.CreateCustomerResponse;
import com.example.rg.dto.response.DeleteCustomerResponse;

public interface RegistrationService {
	
	CreateCustomerResponse createCustomer(CreateCustomerRequest request);
	
	DeleteCustomerResponse deleteCustomer(String kimlikNo);

}
