package com.example.stock.service;

import com.example.stock.dto.request.DropStockRequest;
import com.example.stock.dto.response.DropStockResponse;
import com.example.stock.dto.response.GetStockLeftResponse;
import com.example.stock.dto.response.GetStockResponse;

public interface StockService {
	
	GetStockResponse findStockByIsbn(String isbn);// stokta olup olmadığını bulmak

	GetStockLeftResponse findCopiesStockLeft(String isbn); // stokta ne kadar kaldığını görmek

	DropStockResponse dropBooksFromStock(DropStockRequest request,int basket);

	DropStockResponse DropBooksFromStock(DropStockRequest request);


}
