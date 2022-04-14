package com.example.registration.application.business;


import java.util.Optional;


import com.example.registration.application.CustomerApplication;
import com.example.registration.application.business.exception.CustomerNotFoundException;
import com.example.registration.application.business.exception.ExistingCustomerException;

import com.example.registration.application.events.CustomerCreatedEvent;
import com.example.registration.application.events.CustomerDeletedEvent;
import com.example.registration.domain.Customer;
import com.example.registration.domain.Epurse;
import com.example.registration.domain.TcKimlikNo;
import com.example.registration.infrastructure.EventPublisher;
import com.example.registration.repository.CustomerRepository;

public class StandardCustomerApplication implements CustomerApplication {
	
	private CustomerRepository customerRepository;
	private EventPublisher eventPublisher;
	
	

	public StandardCustomerApplication(CustomerRepository customerRepository, EventPublisher eventPublisher) {
		super();
		this.customerRepository = customerRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		var kimlik = customer.getTcKimlikNo();
		if (customerRepository.existsByKimlikNo(kimlik))
			throw new ExistingCustomerException("Employee already exist", kimlik.getValue());
		Customer savedCustomer = customerRepository.save(customer);
		var businessEvent = new CustomerCreatedEvent(savedCustomer);
		eventPublisher.publishEvent(businessEvent);
		
		return savedCustomer;
	}

	
	

	@Override
	public Customer deleteCustomer(TcKimlikNo kimlik) {
		
		Optional<Customer> removedCustomer = customerRepository.remove(kimlik);
		var customer = removedCustomer.orElseThrow(() -> new CustomerNotFoundException(
        		"Employee does not exist", kimlik.getValue()));
		
		eventPublisher.publishEvent(new CustomerDeletedEvent(customer));
		return customer;

		
	}

}
