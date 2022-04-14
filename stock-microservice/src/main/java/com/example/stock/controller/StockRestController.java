package com.example.stock.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.stock.dto.request.DropStockRequest;
import com.example.stock.dto.response.DropStockResponse;
import com.example.stock.dto.response.GetStockLeftResponse;
import com.example.stock.dto.response.GetStockResponse;
import com.example.stock.service.StockService;

import io.swagger.annotations.Api;

@RestController
@RequestScope
@RequestMapping("stocks")
@CrossOrigin
@Validated
@Api( tags = "Stocks")
public class StockRestController {
	
	private StockService stockService;

	public StockRestController(StockService stockService) {
		this.stockService = stockService;
	}

	@GetMapping
	public GetStockResponse dropStockResponse(@RequestBody @Validated String isbn) {
		return stockService.findStockByIsbn(isbn);
	}
	
	@GetMapping
	public GetStockLeftResponse getStockLeftResponse(@PathVariable String isbn) {
		return stockService.findCopiesStockLeft(isbn);
	}
	@PostMapping
	public DropStockResponse hireEmployee(
			@RequestBody @Validated DropStockRequest request) {
		return stockService.DropBooksFromStock(request);
	}
}

