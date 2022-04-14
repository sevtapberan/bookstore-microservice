package com.example.purchase.repository;

import java.util.List;

import com.example.purchase.domain.Book;
import com.example.purchase.domain.Category;
import com.example.purchase.domain.ISBN;

public interface BookRepository {

	List<Book> findAllByCategory(Category category);

	List<Book> findAllByIsbn(ISBN isbn);

	List<Book> searchAllByIsbn(ISBN isbn);

	boolean existByStockNumber(Object stockNumber);

}
