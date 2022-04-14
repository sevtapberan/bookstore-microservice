package com.example.rg.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.example.registration.application.events.CustomerEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class EventPublisherKafkaAdapter  {
	private static final Logger logger = 
			LoggerFactory.getLogger(EventPublisherKafkaAdapter.class);
	@Value("${registration.events.topic}")
	private String topicName;
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper mapper;
	
	public EventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.mapper = mapper;
	}

	
	}

