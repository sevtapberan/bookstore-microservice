package com.example.bookcatalog.application.business.events;

import java.util.List;

import com.example.bookcatalog.domain.Book;

public class BookListByTitleEvent extends BookEvent {
	private final List<Book> bookList;

	public BookListByTitleEvent(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<Book> getList() {
		return bookList;
	}

}
