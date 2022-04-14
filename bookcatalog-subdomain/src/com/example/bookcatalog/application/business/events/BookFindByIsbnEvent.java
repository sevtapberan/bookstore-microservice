package com.example.bookcatalog.application.business.events;

import com.example.bookcatalog.domain.Book;

public class BookFindByIsbnEvent extends BookEvent {
	private final Book book;

	public BookFindByIsbnEvent(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

}
