package com.example.stock.application;

import java.util.Optional;

import com.example.stock.domain.Basket;
import com.example.stock.domain.Isbn;
import com.example.stock.domain.Stock;

public interface StockApplication {
	
	
	
	Optional<Stock> findStockByIsbn(Isbn isbn);//stokta olup olmadığını bulmak
	
	Stock findCopiesStockLeft(Isbn isbn); //stokta ne kadar kaldığını görmek
	
	Stock dropBooksFromStock( int basket);
	

}
