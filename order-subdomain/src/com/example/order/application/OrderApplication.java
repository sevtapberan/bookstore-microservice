package com.example.order.application;

import java.util.List;
import java.util.Optional;

import com.example.order.domain.Order;
import com.example.order.domain.OrderId;

public interface OrderApplication {

	Order createOrder(Order order);  // yeni sipariþ oluþturma

	List<Order> listOrder(Order order);

	Optional<Order> findOrderByOrderId(OrderId orderId);

	Order removeOrder(OrderId orderId);

	Order createOrder(Order order, int StockKeepingUnit);

	Object findOrderByOrderId(Order order);

	Object addOrder(Order order);
	
}
