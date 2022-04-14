package com.example.rg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.registration.application.CustomerApplication;
import com.example.registration.application.business.StandardCustomerApplication;
import com.example.registration.infrastructure.EventPublisher;
import com.example.registration.repository.CustomerRepository;



@Configuration
public class AppConfig {
	
	@Bean
	public CustomerApplication rgApp(CustomerRepository customerRepository, 
			EventPublisher eventPublisher) {
		return new StandardCustomerApplication(customerRepository, eventPublisher);
	}

}
