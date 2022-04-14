package com.example.stock.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.example.stock.domain.Isbn;
import com.example.stock.domain.Stock;
import com.example.stock.domain.StockNumber;
import com.example.stock.repository.StockDocumentMongoRepository;
import com.example.stock.repository.StockRepository;

public class StockRepositoryMongoAdapter implements StockRepository{
	
	private StockDocumentMongoRepository mongoRepository;
	private ModelMapper modelMapper;


	public StockRepositoryMongoAdapter(StockDocumentMongoRepository mongoRepository, ModelMapper modelMapper) {
		this.mongoRepository = mongoRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Optional<Stock> findByIsbn(Isbn isbn) {
		return mongoRepository.findById(isbn.getValue())
							  .map(stock -> modelMapper.map(stock, Stock.class));
	}

	@Override
	public Optional<Stock> copiesLeft(Isbn isbn) {
		return mongoRepository.findById(isbn.getValue())
				  .map(stock -> modelMapper.map(stock, Stock.class));
	}

	@Override
	public StockNumber addStock(int newItems) {
		return null;
	}

	@Override
	public StockNumber sellFromStock(int soldItems) {
		// TODO Auto-generated method stub
		return null;
	}

}
