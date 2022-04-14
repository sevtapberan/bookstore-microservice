package com.example.stock.repository;

import java.util.Optional;

import com.example.stock.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockNumber;

public interface StockRepository {

	Optional<Stock> findByIsbn(Isbn isbn);

	Optional<Stock> copiesLeft(Isbn isbn);

	public StockNumber addStock(int newItems);

	public StockNumber sellFromStock(int soldItems);

}
