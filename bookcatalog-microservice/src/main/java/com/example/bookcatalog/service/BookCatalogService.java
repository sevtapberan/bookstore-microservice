package com.example.bookcatalog.service;

import java.util.List;

import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.dto.request.AddBookRequest;
import com.example.bookcatalog.dto.response.AddBookResponse;
import com.example.bookcatalog.dto.response.DropBookResponse;
import com.example.bookcatalog.dto.response.FoundedBookByCategoryResponse;
import com.example.bookcatalog.dto.response.FoundedBookByTitleResponse;

public interface BookCatalogService {
	AddBookResponse addbooktoCatolog(AddBookRequest request);

	DropBookResponse dropBookfromCatolog(String isbn);

	List<FoundedBookByCategoryResponse> findBooksByCategory(Category category);

	List<FoundedBookByTitleResponse> findBooksByTitle(String title);
}
