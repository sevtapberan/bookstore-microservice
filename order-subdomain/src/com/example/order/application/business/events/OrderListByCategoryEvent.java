package com.example.order.application.business.events;

import java.util.List;

import com.example.order.domain.Order;

public class OrderListByCategoryEvent extends OrderEvent {
	private final List<Order> orderList;

	public OrderListByCategoryEvent(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

}
