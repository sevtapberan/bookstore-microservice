package com.example.order.service.business;

import org.modelmapper.ModelMapper;

import com.example.order.application.OrderApplication;
import com.example.order.application.business.exceptions.OrderNotFoundException;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;
import com.example.order.dto.request.AddOrderRequest;
import com.example.order.dto.response.AddOrderResponse;
import com.example.order.dto.response.GetOrderResponse;
import com.example.order.service.OrderService;

public class StandardOrderService implements OrderService {
	private OrderApplication orderApplication;
	private ModelMapper modelMapper;

	public StandardOrderService(OrderApplication orderApplication, ModelMapper modelMapper) {
		this.orderApplication = orderApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public GetOrderResponse findOrderByOrderId(String orderId) {
		var order = orderApplication.findOrderByOrderId(OrderId.of(orderId));
		if (order.isEmpty())
			throw new OrderNotFoundException("Cannot find order", orderId);
		return modelMapper.map(order.get(), GetOrderResponse.class);
	}

	@Override
	public AddOrderResponse addorder(AddOrderRequest request) {
		var order = modelMapper.map(request, Order.class);
		var addOrder = orderApplication.addOrder(order);
		return modelMapper.map(addOrder, AddOrderResponse.class);
	}

}
