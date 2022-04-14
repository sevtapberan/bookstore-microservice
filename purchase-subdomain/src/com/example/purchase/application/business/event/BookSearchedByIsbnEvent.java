package com.example.purchase.application.business.event;

import java.util.List;

import com.example.purchase.domain.Book;

public class BookSearchedByIsbnEvent extends BookListByCategoryEvent {

	public BookSearchedByIsbnEvent(List<Book> bookList) {
		super(bookList);
		
	}

}
