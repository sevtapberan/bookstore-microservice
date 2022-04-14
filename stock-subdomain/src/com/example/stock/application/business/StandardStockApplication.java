package com.example.stock.application.business;

import java.util.Optional;

import com.example.stock.application.StockApplication;
import com.example.stock.application.business.events.OutOfStockEvent;
import com.example.stock.application.business.exception.BookNotFoundException;
import com.example.stock.domain.Basket;
import com.example.stock.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.infrastructure.EventPublisher;
import com.example.stock.repository.StockRepository;

public class StandardStockApplication implements StockApplication {
	private StockRepository stockRepository;
	private EventPublisher eventPublisher;



	public StandardStockApplication(StockRepository stockRepository, EventPublisher eventPublisher) {
		this.stockRepository = stockRepository;
		this.eventPublisher = eventPublisher;
	}



	@Override
	public Stock findCopiesStockLeft(Isbn isbn) {
		Optional<Stock> isbnStock= stockRepository.copiesLeft(isbn);
		var isbnCopiesleft = isbnStock.orElseThrow(() -> new BookNotFoundException(
				"This book is out of stock", isbn.getValue()));
		eventPublisher.publishEvent(new OutOfStockEvent(isbnCopiesleft));
		return isbnCopiesleft;
	}

	
	@Override
	public Optional<Stock> findStockByIsbn(Isbn isbn) {
		return stockRepository.findByIsbn(isbn);
	}



	@Override
	public Stock dropBooksFromStock( int basket) {
		// TODO Auto-generated method stub
		return null;
	}



	





	

}
