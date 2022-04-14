package com.example.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bookcatalog.infrastructure.EventPublisher;
import com.example.order.application.OrderApplication;
import com.example.order.application.business.StandardOrderApplication;
import com.example.order.repository.OrderRepository;

@Configuration
public class AppConfig {
	@Bean
	public OrderApplication hrApp(OrderRepository orderRepository, EventPublisher eventPublisher) {
		return new StandardOrderApplication(orderRepository, eventPublisher);
	}

}
