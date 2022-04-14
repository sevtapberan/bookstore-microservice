package com.example.registration.repository;

import java.util.Optional;

import com.example.registration.domain.Customer;
import com.example.registration.domain.TcKimlikNo;

public interface CustomerRepository {

	boolean existsByKimlikNo(TcKimlikNo kimlik);

	Customer save(Customer customer);

	Optional<Customer> remove(TcKimlikNo kimlik);

	
	



}
