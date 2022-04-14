package com.example.order.repository;


import java.util.List;
import java.util.Optional;

import com.example.order.domain.Order;
import com.example.order.domain.OrderId;

public interface OrderRepository {

	boolean existsByOrder(OrderId orderId);

	Order save(OrderId orderId);

	List<Order> findAllByOrder(Order order);

	Optional<Order> findOneByOrder(OrderId orderId);

	Optional<Order> remove(OrderId orderId);
	
}
