package com.example.rg.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;


import com.example.registration.domain.Customer;
import com.example.registration.domain.TcKimlikNo;
import com.example.registration.repository.CustomerRepository;
import com.example.rg.document.CustomerDocument;
import com.example.rg.repository.CustomerDocumentMongoRepository;

public class CustomerRepositoryMongoAdapter implements CustomerRepository {
	
	private CustomerDocumentMongoRepository mongoRepo;
    private ModelMapper mapper;
    
    

	public CustomerRepositoryMongoAdapter(CustomerDocumentMongoRepository mongoRepo, ModelMapper mapper) {
		super();
		this.mongoRepo = mongoRepo;
		this.mapper = mapper;
	}

	@Override
	public boolean existsByKimlikNo(TcKimlikNo kimlik) {
		
		return mongoRepo.existsById(kimlik.getValue());
	}

	@Override
	public Customer save(Customer customer) {
		var document = mapper.map(customer, CustomerDocument.class);
		 return mapper.map(mongoRepo.save(document),Customer.class);
	}

	@Override
	public Optional<Customer> remove(TcKimlikNo kimlik) {
		var document = mongoRepo.findById(kimlik.getValue());
		document.ifPresent( mongoRepo::delete);
		return document.map(doc -> mapper.map(doc, Customer.class));
	}

}
