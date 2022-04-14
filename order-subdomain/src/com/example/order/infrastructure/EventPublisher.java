package com.example.order.infrastructure;

import com.example.order.application.business.events.OrderCreatedEvent;
import com.example.order.application.business.events.OrderEvent;

public interface EventPublisher {
	void publishEvent(OrderEvent businessEvent);

	void publishEvent(OrderCreatedEvent orderCreatedEvent);

}
