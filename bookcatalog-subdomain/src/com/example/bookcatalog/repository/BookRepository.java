package com.example.bookcatalog.repository;

import java.util.List;
import java.util.Optional;

import com.example.bookcatalog.domain.Book;
import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.domain.ISBN;
import com.example.bookcatalog.domain.Title;

public interface BookRepository {

	boolean existsByIsbn(ISBN isbn);

	Book save(Book book);

	Optional<Book> remove(ISBN isbn);

	List<Book> findAllByCategory(Category category);

	List<Book> findAllByTitle(Title title);

	Optional<Book> findOneByIsbn(ISBN isbn);

}
