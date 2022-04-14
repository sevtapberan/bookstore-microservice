package com.example.stock.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.stock.application.business.events.StockEvent;
import com.example.stock.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventStockKafkaAdapter implements EventPublisher{

	private static final Logger logger = 
			LoggerFactory.getLogger(EventStockKafkaAdapter.class);
	@Value("${employee.events.topic}")
	private String topicName;
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper mapper;
	
	public EventStockKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.mapper = mapper;
	}

	

	@Override
	public void publishEvent(StockEvent stockEvent) {
		try {
			var eventAsJson = mapper.writeValueAsString(stockEvent);
			kafkaTemplate.send(topicName, eventAsJson);
		} catch (JsonProcessingException e) {
			logger.error("Error while converting the event to json: {}",
					e.getMessage());
		}
		
	}

}
