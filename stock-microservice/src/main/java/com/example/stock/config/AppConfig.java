package com.example.stock.config;

import org.springframework.context.annotation.Configuration;

import com.example.stock.application.StockApplication;
import com.example.stock.application.business.StandardStockApplication;
import com.example.stock.infrastructure.EventPublisher;
import com.example.stock.repository.StockRepository;



@Configuration
public class AppConfig {
	
	public StockApplication stockApp(StockRepository stockRepository, EventPublisher eventPublisher) {
		return new StandardStockApplication(stockRepository, eventPublisher);
	}

}
