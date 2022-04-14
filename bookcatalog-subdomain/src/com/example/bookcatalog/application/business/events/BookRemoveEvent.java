package com.example.bookcatalog.application.business.events;

import com.example.bookcatalog.domain.Book;

public class BookRemoveEvent extends BookEvent{
	private final Book book;

	public BookRemoveEvent(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}
}
