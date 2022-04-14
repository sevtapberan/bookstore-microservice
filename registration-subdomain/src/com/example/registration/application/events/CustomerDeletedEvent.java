package com.example.registration.application.events;

import com.example.registration.domain.Customer;

public class CustomerDeletedEvent extends CustomerEvent {
	
	private final Customer customer;

	public CustomerDeletedEvent(Customer customer) {
		this.customer = customer;
	}

	public Customer getEmployee() {
		return customer;
	}
	
	

}
