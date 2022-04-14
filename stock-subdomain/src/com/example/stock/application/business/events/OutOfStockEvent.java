package com.example.stock.application.business.events;

import com.example.stock.domain.Stock;

public class OutOfStockEvent extends StockEvent {

	private final Stock stock;

	public OutOfStockEvent(Stock stock) {
		this.stock = stock;
	}

	public Stock getStock() {
		return stock;
	}

	
}
