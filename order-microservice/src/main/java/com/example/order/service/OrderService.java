package com.example.order.service;

import com.example.order.domain.Order;
import com.example.order.dto.request.AddOrderRequest;
import com.example.order.dto.response.AddOrderResponse;
import com.example.order.dto.response.CancelOrderResponse;
import com.example.order.dto.response.GetOrderResponse;

public interface OrderService {

	AddOrderResponse addorder(AddOrderRequest request);

	GetOrderResponse findOrderByOrderId(String orderId);


}
