package com.example.bookcatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bookcatalog.application.BookCatalogApplication;
import com.example.bookcatalog.application.business.StandardBookCatalogApplication;
import com.example.bookcatalog.infrastructure.EventPublisher;
import com.example.bookcatalog.repository.BookRepository;

@Configuration
public class AppConfig {
	@Bean
	public BookCatalogApplication hrApp(BookRepository bookRepository, EventPublisher eventPublisher) {
		return new StandardBookCatalogApplication(bookRepository, eventPublisher);
	}
}
