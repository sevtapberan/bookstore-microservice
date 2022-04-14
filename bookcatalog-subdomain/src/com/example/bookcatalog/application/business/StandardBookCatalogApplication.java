package com.example.bookcatalog.application.business;

import java.util.List;
import java.util.Optional;

import com.example.bookcatalog.application.BookCatalogApplication;
import com.example.bookcatalog.application.business.events.BookCreatedEvent;
import com.example.bookcatalog.application.business.events.BookListByCategoryEvent;
import com.example.bookcatalog.application.business.events.BookListByTitleEvent;
import com.example.bookcatalog.application.business.events.BookRemoveEvent;
import com.example.bookcatalog.application.business.exceptions.BookNotFoundException;
import com.example.bookcatalog.application.business.exceptions.ExistingBookException;
import com.example.bookcatalog.domain.Book;
import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.domain.ISBN;
import com.example.bookcatalog.domain.Title;
import com.example.bookcatalog.infrastructure.EventPublisher;
import com.example.bookcatalog.repository.BookRepository;

public class StandardBookCatalogApplication implements BookCatalogApplication {
	private BookRepository bookRepository;
	private EventPublisher eventPublisher;

	public StandardBookCatalogApplication(BookRepository bookRepository, EventPublisher eventPublisher) {
		this.bookRepository = bookRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Book addbooktoCatolog(Book book) {
		var isbn = book.getIsbn();
		if (bookRepository.existsByIsbn(isbn))
			throw new ExistingBookException("Book already exist", isbn.getValue());
		Book savedBook = bookRepository.save(book);
		eventPublisher.publishEvent(new BookCreatedEvent(savedBook));
		return savedBook;
	}

	@Override
	public Book dropBookfromCatolog(ISBN isbn) {
		Optional<Book> removedBook = bookRepository.remove(isbn);
		var book = removedBook.orElseThrow(() -> new BookNotFoundException("Book does not exist", isbn.getValue()));
		eventPublisher.publishEvent(new BookRemoveEvent(book));
		return book;

	}

	@Override
	public List<Book> findBooksByCategory(Category category) {
		List<Book> bookList = bookRepository.findAllByCategory(category);
		eventPublisher.publishEvent(new BookListByCategoryEvent(bookList));
		return bookList;
	}

	@Override
	public List<Book> findBookByTitle(Title title) {
		List<Book> bookList = bookRepository.findAllByTitle(title);
		eventPublisher.publishEvent(new BookListByTitleEvent(bookList));
		return bookList;

	}

}
