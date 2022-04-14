package com.example.bookcatalog.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bookcatalog.document.BookDocument;
import com.example.bookcatalog.domain.Book;
import com.example.bookcatalog.dto.request.AddBookRequest;
import com.example.bookcatalog.dto.response.AddBookResponse;
import com.example.bookcatalog.dto.response.DropBookResponse;
import com.example.bookcatalog.dto.response.FoundedBookByCategoryResponse;
import com.example.bookcatalog.dto.response.FoundedBookByTitleResponse;

@Configuration
public class ModelMapperConfig {
	private static final Converter<Book, AddBookResponse> BOOK_TO_ADD_BOOK_RESPONSE_CONVERTER = (context) -> {
		var book = context.getSource();
		var response = new AddBookResponse();

		response.setIsbn(book.getIsbn().getValue());
		response.setTitle(book.getTitle().getValue());

		System.err.println("BOOK_TO_ADD_BOOK_RESPONSE_CONVERTER : " + response);
		return response;
	};
	private static final Converter<Book, DropBookResponse> BOOK_TO_DROP_BOOK_RESPONSE_CONVERTER = (context) -> {
		var book = context.getSource();
		var response = new DropBookResponse();

		response.setIsbn(book.getIsbn().getValue());
		response.setTitle(book.getTitle().getValue());

		return response;
	};
	private static final Converter<Book, FoundedBookByCategoryResponse> BOOK_TO_FOUNDED_BOOK_BY_CATEGORY_RESPONSE_CONVERTER = (
			context) -> {
		var book = context.getSource();
		var response = new FoundedBookByCategoryResponse();

		response.setIsbn(book.getIsbn().getValue());
		response.setTitle(book.getTitle().getValue());
		response.setAuthor(book.getAuthor().getValue());
		response.setPublisher(book.getPublisher().getValue());
		response.setEdition(book.getEdition().getValue());
		response.setPublicationYear(book.getPublicationYear().getValue());
		response.setPrice(book.getPrice().getValue());
		response.setReviews(book.getReviews().getValue());
		response.setContents(book.getContents().getValue());
		response.setPhoto(book.getCoverPhoto().getValue());
		response.setPopularity(book.getPopularity().getValue());
		response.setCategory(book.getCategory());

		return response;
	};
	private static final Converter<Book, FoundedBookByTitleResponse> BOOK_TO_FOUNDED_BOOK_BY_TITLE_RESPONSE_CONVERTER = (
			context) -> {
		var book = context.getSource();
		var response = new FoundedBookByTitleResponse();

		response.setIsbn(book.getIsbn().getValue());
		response.setTitle(book.getTitle().getValue());
		response.setAuthor(book.getAuthor().getValue());
		response.setPublisher(book.getPublisher().getValue());
		response.setEdition(book.getEdition().getValue());
		response.setPublicationYear(book.getPublicationYear().getValue());
		response.setPrice(book.getPrice().getValue());
		response.setReviews(book.getReviews().getValue());
		response.setContents(book.getContents().getValue());
		response.setPhoto(book.getCoverPhoto().getValue());
		response.setPopularity(book.getPopularity().getValue());
		response.setCategory(book.getCategory());

		return response;
	};
	private static final Converter<AddBookRequest, Book> ADD_BOOK_REQUEST_TO_BOOK_CONVERTER = (context) -> {
		var request = context.getSource();
		return new Book.Builder().isbn(request.getIsbn()).title(request.getTitle()).author(request.getAuthor())
				.publisher(request.getPublisher()).edition(request.getEdition())
				.publicationYear(request.getPublicationYear()).price(request.getPrice()).reviews(request.getReviews())
				.contents(request.getContents()).coverPhoto(request.getPhoto()).popularity(request.getPopularity())
				.category(request.getCategory().name()).build();

	};
	private static final Converter<BookDocument, Book> BOOK_DOCUMENT_TO_BOOK_CONVERTER = (context) -> {
		var document = context.getSource();
		return new Book.Builder().isbn(document.getIsbn()).title(document.getTitle()).author(document.getAuthor())
				.publisher(document.getPublisher()).edition(document.getEdition())
				.publicationYear(document.getPublicationYear()).price(document.getPrice())
				.reviews(document.getReviews()).contents(document.getContents()).coverPhoto(document.getPhoto())
				.popularity(document.getPopularity()).category(document.getCategory().name()).build();
	};
	private static final Converter<Book, BookDocument> BOOK_TO_BOOK_DOCUMENT_CONVERTER = (context) -> {
		var book = context.getSource();
		var bookDoc = new BookDocument();

		bookDoc.setIsbn(book.getIsbn().getValue());
		bookDoc.setTitle(book.getTitle().getValue());
		bookDoc.setAuthor(book.getAuthor().getValue());
		bookDoc.setPublisher(book.getPublisher().getValue());
		bookDoc.setEdition(book.getEdition().getValue());
		bookDoc.setPublicationYear(book.getPublicationYear().getValue());
		bookDoc.setPrice(book.getPrice().getValue());
		bookDoc.setReviews(book.getReviews().getValue());
		bookDoc.setContents(book.getContents().getValue());
		bookDoc.setPhoto(book.getCoverPhoto().getValue());
		bookDoc.setPopularity(book.getPopularity().getValue());
		bookDoc.setCategory(book.getCategory());
		return bookDoc;
	};

	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(BOOK_TO_ADD_BOOK_RESPONSE_CONVERTER, Book.class, AddBookResponse.class);
		mapper.addConverter(BOOK_TO_DROP_BOOK_RESPONSE_CONVERTER, Book.class, DropBookResponse.class);
		mapper.addConverter(BOOK_TO_FOUNDED_BOOK_BY_CATEGORY_RESPONSE_CONVERTER, Book.class,
				FoundedBookByCategoryResponse.class);
		mapper.addConverter(BOOK_TO_FOUNDED_BOOK_BY_TITLE_RESPONSE_CONVERTER, Book.class,
				FoundedBookByTitleResponse.class);
		mapper.addConverter(ADD_BOOK_REQUEST_TO_BOOK_CONVERTER, AddBookRequest.class, Book.class);
		mapper.addConverter(BOOK_DOCUMENT_TO_BOOK_CONVERTER, BookDocument.class, Book.class);
		mapper.addConverter(BOOK_TO_BOOK_DOCUMENT_CONVERTER, Book.class, BookDocument.class);
		return mapper;
	}
}
