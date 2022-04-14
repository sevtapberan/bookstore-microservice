package com.example.order.adapter;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.example.order.document.OrderDocument;
import com.example.order.domain.Order;
import com.example.order.domain.OrderId;
import com.example.order.repository.OrderDocumentMongoRepository;
import com.example.order.repository.OrderRepository;

public class OrderRepositoryMongoAdapter implements OrderRepository{
	private OrderDocumentMongoRepository mongoRepo;
	private ModelMapper mapper;
	
	public OrderRepositoryMongoAdapter(OrderDocumentMongoRepository mongoRepo, ModelMapper mapper) {
		this.mongoRepo = mongoRepo;
		this.mapper = mapper;
	}

	@Override
	public boolean existsByOrder(OrderId orderId) {
		return mongoRepo.existsByOrder(orderId.getValue());
	}

	@Override
	public Order save(OrderId orderId) {
		var document = mapper.map(orderId, OrderDocument.class);
		return mapper.map(mongoRepo.save(document), Order.class);
	}


	@Override
	public List<Order> findAllByOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Order> findOneByOrder(OrderId orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Order> remove(OrderId orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
