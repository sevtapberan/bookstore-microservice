package com.example.stock.service.business;

import org.modelmapper.ModelMapper;

import com.example.stock.application.StockApplication;
import com.example.stock.application.business.exception.BookNotFoundException;
import com.example.stock.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.dto.request.DropStockRequest;
import com.example.stock.dto.response.DropStockResponse;
import com.example.stock.dto.response.GetStockLeftResponse;
import com.example.stock.dto.response.GetStockResponse;
import com.example.stock.service.StockService;

public class StandardStockService implements StockService{

	private StockApplication stockApplication;
	private ModelMapper modelMapper;
	
	
	
	public StandardStockService(StockApplication stockApplication, ModelMapper modelMapper) {
		this.stockApplication = stockApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public GetStockResponse findStockByIsbn(String isbn) {
		var stock = stockApplication.findStockByIsbn(Isbn.of(isbn));
		if(stock.isEmpty()) throw new BookNotFoundException("Cannot find book",isbn);
		return modelMapper.map(stock.get(), GetStockResponse.class);
	}

	@Override
	public GetStockLeftResponse findCopiesStockLeft(String isbn) {
		var stockLeft = stockApplication.findStockByIsbn(Isbn.of(isbn));
		if(stockLeft.isEmpty()) throw new BookNotFoundException("Cannot find book",isbn);
		return modelMapper.map(stockLeft.get(), GetStockLeftResponse.class);
	}

	@Override
	public DropStockResponse dropBooksFromStock(DropStockRequest request,int basket) {
		var stock = modelMapper.map(request, Stock.class);
		var stockDrop = stockApplication.dropBooksFromStock(basket);
		return modelMapper.map(stockDrop, DropStockResponse.class);
	}

	@Override
	public DropStockResponse DropBooksFromStock(DropStockRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
