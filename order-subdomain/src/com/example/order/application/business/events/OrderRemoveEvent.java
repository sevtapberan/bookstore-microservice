package com.example.order.application.business.events;

import com.example.order.domain.Order;

public class OrderRemoveEvent extends OrderEvent {
	private final Order order;

	public OrderRemoveEvent(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

}
