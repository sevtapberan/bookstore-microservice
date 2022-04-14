package com.example.bookcatalog.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.dto.request.AddBookRequest;
import com.example.bookcatalog.dto.response.AddBookResponse;
import com.example.bookcatalog.dto.response.DropBookResponse;
import com.example.bookcatalog.dto.response.FoundedBookByCategoryResponse;
import com.example.bookcatalog.dto.response.FoundedBookByTitleResponse;
import com.example.bookcatalog.service.BookCatalogService;
import com.example.bookcatalog.validation.Isbn;

import io.swagger.annotations.Api;

@RestController
@RequestScope
@RequestMapping("bookcatalog")
@CrossOrigin
@Validated
@Api(tags = "Bookcatalog")
public class BookCatalogRestController {
	private BookCatalogService bookCatalogService;

	public BookCatalogRestController(BookCatalogService bookCatalogService) {
		this.bookCatalogService = bookCatalogService;
	}

	@PostMapping
	public AddBookResponse addbooktoCatolog(@RequestBody @Validated AddBookRequest request) {
		return bookCatalogService.addbooktoCatolog(request);
	}

	public DropBookResponse dropBookfromCatolog(@PathVariable @Isbn String isbn) {
		return bookCatalogService.dropBookfromCatolog(isbn);
	}

	public List<FoundedBookByCategoryResponse> findBooksByCategory(@PathVariable Category category) {
		return bookCatalogService.findBooksByCategory(category);
	}

	public List<FoundedBookByTitleResponse> findBooksByTitle(@PathVariable String title) {
		return bookCatalogService.findBooksByTitle(title);
	}

}
