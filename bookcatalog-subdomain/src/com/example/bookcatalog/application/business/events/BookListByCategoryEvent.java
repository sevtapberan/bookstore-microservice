package com.example.bookcatalog.application.business.events;

import java.util.List;

import com.example.bookcatalog.domain.Book;

public class BookListByCategoryEvent extends BookEvent {
	private final List<Book> bookList;

	public BookListByCategoryEvent(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

}
