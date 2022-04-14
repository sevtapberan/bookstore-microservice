package com.example.purchase.application;

import com.example.purchase.domain.ISBN;
import com.example.purchase.domain.Order;

import java.util.List;

import com.example.purchase.domain.Book;
import com.example.purchase.domain.Category;
import com.example.purchase.domain.Price;

public interface PurchaseApplication {

	Book saleBook(Price price);

	List<Book> listBook(Category category);

	List<Book> searchBook(ISBN isbn);

	Order orderBook(Order order, int StockNumber);

}
