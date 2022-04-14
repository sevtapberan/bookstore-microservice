package com.example.registration.application.events;

import com.example.registration.domain.Customer;

public class CustomerCreatedEvent extends CustomerEvent{
	
	private final Customer customer;

	public CustomerCreatedEvent(Customer savedCustomer) {
		
		this.customer = savedCustomer;
	}
	
	public Customer getEmployee() {
		return customer;
	}

}
