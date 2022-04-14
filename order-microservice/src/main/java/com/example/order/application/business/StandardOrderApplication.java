package com.example.order.application.business;

import java.util.List;
import java.util.Optional;

import com.example.bookcatalog.infrastructure.EventPublisher;
import com.example.order.application.OrderApplication;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;
import com.example.order.repository.OrderRepository;

public class StandardOrderApplication implements OrderApplication {

	public StandardOrderApplication(OrderRepository orderRepository, EventPublisher eventPublisher) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Order> findOrderByOrderId(OrderId orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order removeOrder(OrderId orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order createOrder(Order order, int StockKeepingUnit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findOrderByOrderId(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object addOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
