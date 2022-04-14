package com.example.bookcatalog.service.business;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.bookcatalog.application.BookCatalogApplication;
import com.example.bookcatalog.domain.Book;
import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.domain.ISBN;
import com.example.bookcatalog.domain.Title;
import com.example.bookcatalog.dto.request.AddBookRequest;
import com.example.bookcatalog.dto.response.AddBookResponse;
import com.example.bookcatalog.dto.response.DropBookResponse;
import com.example.bookcatalog.dto.response.FoundedBookByCategoryResponse;
import com.example.bookcatalog.dto.response.FoundedBookByTitleResponse;
import com.example.bookcatalog.service.BookCatalogService;

public class StandardBookCatalogService implements BookCatalogService {
	private BookCatalogApplication bookCatalogApplication;
	private ModelMapper modelMapper;

	public StandardBookCatalogService(BookCatalogApplication bookCatalogApplication, ModelMapper modelMapper) {
		this.bookCatalogApplication = bookCatalogApplication;
		this.modelMapper = modelMapper;
	}

	@Override
	public AddBookResponse addbooktoCatolog(AddBookRequest request) {
		var book = modelMapper.map(request, Book.class);
		var addedBook = bookCatalogApplication.addbooktoCatolog(book);
		return modelMapper.map(addedBook, AddBookResponse.class);
	}

	@Override
	public DropBookResponse dropBookfromCatolog(String isbn) {
		var book = bookCatalogApplication.dropBookfromCatolog(ISBN.of(isbn));
		return modelMapper.map(book, DropBookResponse.class);
	}

	@Override
	public List<FoundedBookByCategoryResponse> findBooksByCategory(Category category) {
		var bookList = bookCatalogApplication.findBooksByCategory(category);
		return bookList.stream().map(book -> modelMapper.map(book, FoundedBookByCategoryResponse.class)).toList();
	}

	@Override
	public List<FoundedBookByTitleResponse> findBooksByTitle(String title) {
		var bookList = bookCatalogApplication.findBookByTitle(Title.of(title));
		return bookList.stream().map(book -> modelMapper.map(book, FoundedBookByTitleResponse.class)).toList();
	}

}
