package com.example.publisher.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.publisher.application.business.events.PublisherEvent;
import com.example.publisher.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventPublisherKafkaAdapter implements EventPublisher{

	private static final Logger logger = 
			LoggerFactory.getLogger(EventPublisherKafkaAdapter.class);
	@Value("${employee.events.topic}")
	private String topicName;
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper mapper;
	
	public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.mapper = mapper;
	}
	@Override
	public void publishEvent(PublisherEvent businessEvent) {
		try {
			var eventAsJson = mapper.writeValueAsString(businessEvent);
			kafkaTemplate.send(topicName, eventAsJson);
		} catch (JsonProcessingException e) {
			logger.error("Error while converting the event to json: {}",
					e.getMessage());
		}
	}

}
