package com.example.order.application.business;

import java.util.List;
import java.util.Optional;
import com.example.order.application.OrderApplication;
import com.example.order.application.business.events.OrderCreatedEvent;
import com.example.order.application.business.events.OrderListByCategoryEvent;
import com.example.order.application.business.events.OrderRemoveEvent;
import com.example.order.application.business.exceptions.ExistingOrderException;
import com.example.order.application.business.exceptions.OrderNotFoundException;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;
import com.example.order.infrastructure.EventPublisher;
import com.example.order.repository.OrderRepository;

public abstract class StandartOrderApplication implements OrderApplication {
	private OrderRepository orderRepository;
	private EventPublisher eventPublisher;

	public StandartOrderApplication(OrderRepository orderRepository, EventPublisher eventPublisher) {
		this.orderRepository = orderRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Order createOrder(Order order, int stockKeepingUnit) { // sipariþ oluþturma
		var orderId = order.getOrderId();
		if (orderRepository.existsByOrder(orderId))
			throw new ExistingOrderException("Order already exist", orderId.getValue());
		else if (stockKeepingUnit < 10) {// stok ta 10 dan az ise sipariþ ver
			Order savedOrder = orderRepository.save(orderId);
			eventPublisher.publishEvent(new OrderCreatedEvent(savedOrder));
			return savedOrder;
		}
		return order;

	}

	@Override
	public List<Order> listOrder(Order order) { // sipariþleri listele
		List<Order> orderList = orderRepository.findAllByOrder(order);
		eventPublisher.publishEvent(new OrderListByCategoryEvent(orderList));
		return orderList;
	}

	@Override
	public Optional<Order> findOrderByOrderId(OrderId orderId) {// orderId ye göre sipariþ bulma
		return orderRepository.findOneByOrder(orderId);
	}

	@Override
	public Order removeOrder(OrderId orderId) { // sipariþ iptal etmek
		Optional<Order> removedOrder = orderRepository.remove(orderId);
		var order = removedOrder
				.orElseThrow(() -> new OrderNotFoundException("Order does not exist", orderId.getValue()));
		eventPublisher.publishEvent(new OrderRemoveEvent(order));
		return order;
	}

}
