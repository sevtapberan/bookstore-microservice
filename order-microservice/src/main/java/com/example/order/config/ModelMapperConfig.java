package com.example.order.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.order.document.OrderDocument;
import com.example.order.domain.Order;
import com.example.order.dto.response.AddOrderResponse;
import com.example.order.dto.response.DropOrderResponse;

@Configuration
public class ModelMapperConfig {
	private static final Converter<Order, AddOrderResponse> ORDER_TO_ADD_ORDER_RESPONSE_CONVERTER = (context) -> {
		var order = context.getSource();
		var response = new AddOrderResponse();

		response.setOrderId(order.getOrderId().getValue());

		System.err.println("ORDER_TO_ADD_ORDER_RESPONSE_CONVERTER : " + response);
		return response;
	};
	private static final Converter<Order, DropOrderResponse> ORDER_TO_DROP_ORDER_RESPONSE_CONVERTER = (context) -> {
		var order = context.getSource();
		var response = new DropOrderResponse();

		response.setOrderId(order.getOrderId().getValue());

		return response;
	};
	private static final Converter<OrderDocument, Order> ORDER_DOCUMENT_TO_ORDER_CONVERTER = (context) -> {
		var document = context.getSource();
		return new Order.Builder().orderId(document.getOrder()).build();
	};
	private static final Converter<Order, OrderDocument> ORDER_TO_ORDER_DOCUMENT_CONVERTER = (context) -> {
		var order = context.getSource();
		var orderDoc = new OrderDocument();

		orderDoc.setOrderId(order.getOrderId().getValue());

		return orderDoc;
	};

	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(ORDER_TO_ADD_ORDER_RESPONSE_CONVERTER, Order.class, AddOrderResponse.class);
		mapper.addConverter(ORDER_TO_DROP_ORDER_RESPONSE_CONVERTER, Order.class, DropOrderResponse.class);
		mapper.addConverter(ORDER_TO_ORDER_DOCUMENT_CONVERTER, Order.class, OrderDocument.class);
		mapper.addConverter(ORDER_DOCUMENT_TO_ORDER_CONVERTER, OrderDocument.class, Order.class);
		return mapper;
	}
}
