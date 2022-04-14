package com.example.publisher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.publisher.application.PublisherApplication;
import com.example.publisher.application.business.StandardPublisherApplication;
import com.example.publisher.infrastructure.EventPublisher;
import com.example.publisher.repository.PublisherRepository;

@Configuration
public class AppConfig {
	
	@Bean
	public PublisherApplication publisherApp(PublisherRepository publisherRepository, EventPublisher eventPublisher) {
		return new  StandardPublisherApplication(publisherRepository, eventPublisher);
	}

}
