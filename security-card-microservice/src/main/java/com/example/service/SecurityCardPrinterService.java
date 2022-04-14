package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SecurityCardPrinterService {

	@KafkaListener(topics = "book-events", groupId = "security-card")
	public void listenEvents(String event) {
		System.out.println(event);
	}
}