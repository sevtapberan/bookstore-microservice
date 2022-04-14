package com.example.order.application.business.events;

import com.example.order.domain.Order;

public class OrderCreatedEvent {
	private final Order order;

	public OrderCreatedEvent(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}
}
