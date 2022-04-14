package com.example.registration.application;


import com.example.registration.domain.Customer;
import com.example.registration.domain.Epurse;
import com.example.registration.domain.TcKimlikNo;

public interface CustomerApplication {
	
	Customer createCustomer(Customer customer);
	
	Customer deleteCustomer(TcKimlikNo kimlik);
	
	
	
	
	

}
