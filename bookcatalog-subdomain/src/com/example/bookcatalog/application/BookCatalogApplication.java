package com.example.bookcatalog.application;

import java.util.List;

import com.example.bookcatalog.domain.Book;
import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.domain.ISBN;
import com.example.bookcatalog.domain.Title;

public interface BookCatalogApplication {

	Book addbooktoCatolog(Book book);

	Book dropBookfromCatolog(ISBN isbn);

	List<Book> findBooksByCategory(Category category);

	List<Book> findBookByTitle(Title title);
}
