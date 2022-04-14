package com.example.order.repository;

import com.example.order.document.OrderDocument;
import com.example.order.domain.Order;

public interface OrderDocumentMongoRepository {

	boolean existsByOrder(String value);

	Object save(OrderDocument document);

	Object findAllByOrder(Order order);

}
