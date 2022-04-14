package com.example.purchase.application.business.event;

import java.util.List;

import com.example.purchase.domain.Book;

public class OrderCreatedEvent extends BookListByCategoryEvent {

	public OrderCreatedEvent(List<Book> bookList) {
		super(bookList);
	
	}

}
