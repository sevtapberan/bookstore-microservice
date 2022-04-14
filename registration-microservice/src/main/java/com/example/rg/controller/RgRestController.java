package com.example.rg.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.rg.dto.request.CreateCustomerRequest;
import com.example.rg.dto.response.CreateCustomerResponse;
import com.example.rg.dto.response.DeleteCustomerResponse;
import com.example.rg.service.RegistrationService;
import com.example.validation.TcKimlikNo;

import io.swagger.annotations.Api;

@RestController
@RequestScope
@RequestMapping("customer")
@CrossOrigin
@Validated
@Api( tags = "customers")
public class RgRestController {
	
	private RegistrationService registrationService;
	
	

	public RgRestController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}



	@PostMapping 
	public CreateCustomerResponse createCustomer(
			@RequestBody @Validated CreateCustomerRequest request) {
		return registrationService.createCustomer(request);
	}
	
	
	@DeleteMapping("{kimlikNo}")
	
	public DeleteCustomerResponse deleteCustomer(
			@PathVariable @TcKimlikNo String kimlikNo) {
		return registrationService.deleteCustomer(kimlikNo);
}







	









}
