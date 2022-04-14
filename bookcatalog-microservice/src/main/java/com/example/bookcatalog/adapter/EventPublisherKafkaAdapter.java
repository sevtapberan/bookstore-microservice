package com.example.bookcatalog.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.bookcatalog.application.business.events.BookEvent;
import com.example.bookcatalog.infrastructure.EventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventPublisherKafkaAdapter implements EventPublisher {
	private static final Logger logger = LoggerFactory.getLogger(EventPublisherKafkaAdapter.class);

	@Value("${book.events.topic}")
	private String topicName;

	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper mapper;

	public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.mapper = mapper;
	}

	@Override
	public void publishEvent(BookEvent businessEvent) {
		try {
			var eventAsJson = mapper.writeValueAsString(businessEvent);
			kafkaTemplate.send(topicName, eventAsJson);
		} catch (JsonProcessingException e) {
			logger.error("Error while converting the event to json: {}", e.getMessage());
		}
	}

}
