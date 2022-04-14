package com.example.order.application.business.events;

import java.util.List;

import com.example.order.domain.Order;

public class OrderListByTitleEvent extends OrderEvent {
	private final List<Order> orderList;

	public OrderListByTitleEvent(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

}
