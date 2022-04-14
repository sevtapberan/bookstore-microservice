package com.example.purchase.application.business;

import java.util.List;

import com.example.purchase.application.PurchaseApplication;
import com.example.purchase.domain.StockNumber;
import com.example.purchase.application.business.event.BookListByCategoryEvent;
import com.example.purchase.application.business.event.BookSearchedByIsbnEvent;
import com.example.purchase.application.business.event.OrderCreatedEvent;
import com.example.purchase.application.business.exceptions.ExistingOrderException;

import com.example.purchase.application.infrastructure.EventPublisher;
import com.example.purchase.domain.Book;
import com.example.purchase.domain.Category;
import com.example.purchase.domain.ISBN;
import com.example.purchase.domain.Order;
import com.example.purchase.domain.Price;
import com.example.purchase.repository.BookRepository;
import com.example.purchase.repository.orderRepository;


public  class StandartPurchaseApplication implements PurchaseApplication{
	private BookRepository bookRepository;
	private EventPublisher eventPublisher;
	@Override
	public List<Book> searchBook(ISBN isbn) {
		List<Book> bookList = bookRepository.searchAllByIsbn(isbn);
		eventPublisher.publishEvent(new BookSearchedByIsbnEvent(bookList));
		return bookList;
	}
	@Override
	public List<Book> listBook(Category category) {
		List<Book> bookList = bookRepository.findAllByCategory(category);
		eventPublisher.publishEvent(new BookListByCategoryEvent(bookList));
		return bookList;
	}
	@Override
	public Book saleBook(Price price) {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Order orderBook(Order order, int StockNumber) {
		
		var orderId = order.getOrderId();
		if (orderRepository.existsByOrder(orderId))
			throw new ExistingOrderException("Order is exist", orderId.getValue());
		else if (StockNumber <= 0) {
			Order savedOrder = orderRepository.save(orderId);
			eventPublisher.publishEvent(new OrderCreatedEvent((List<Book>) savedOrder));
			return savedOrder;
		}
		return order;
	}
}

	
	


