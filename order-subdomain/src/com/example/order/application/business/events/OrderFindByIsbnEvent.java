package com.example.order.application.business.events;

import com.example.order.domain.Order;

public class OrderFindByIsbnEvent extends OrderEvent {
	private final Order order;

	public OrderFindByIsbnEvent(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

}
