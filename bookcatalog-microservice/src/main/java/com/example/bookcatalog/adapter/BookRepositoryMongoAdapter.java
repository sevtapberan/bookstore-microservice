package com.example.bookcatalog.adapter;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.example.bookcatalog.document.BookDocument;
import com.example.bookcatalog.domain.Book;
import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.domain.ISBN;
import com.example.bookcatalog.domain.Title;
import com.example.bookcatalog.repository.BookDocumentMongoRepository;
import com.example.bookcatalog.repository.BookRepository;

@Repository
public class BookRepositoryMongoAdapter implements BookRepository {
	private BookDocumentMongoRepository mongoRepo;
	private ModelMapper mapper;

	public BookRepositoryMongoAdapter(BookDocumentMongoRepository mongoRepo, ModelMapper mapper) {
		this.mongoRepo = mongoRepo;
		this.mapper = mapper;
	}

	@Override
	public boolean existsByIsbn(ISBN isbn) {
		return mongoRepo.existsById(isbn.getValue());
	}

	@Override
	public Book save(Book book) {
		var document = mapper.map(book, BookDocument.class);
		return mapper.map(mongoRepo.save(document), Book.class);
	}

	@Override
	public Optional<Book> remove(ISBN isbn) {
		var document = mongoRepo.findByIsbn(isbn.getValue());
		document.ifPresent(mongoRepo::delete);
		return document.map(doc -> mapper.map(doc, Book.class));
	}

	@Override
	public List<Book> findAllByCategory(Category category) {
		var document = mongoRepo.findAllByCategory(category);
		return document.stream().map(doc -> mapper.map(doc, Book.class)).toList();
	}

	@Override
	public List<Book> findAllByTitle(Title title) {
		var document = mongoRepo.findByTitleLike(title.getValue());
		return document.stream().map(doc -> mapper.map(doc, Book.class)).toList();
	}

	@Override
	public Optional<Book> findOneByIsbn(ISBN isbn) {
		var document = mongoRepo.findByIsbn(isbn.getValue());
		return document.map(doc -> mapper.map(doc, Book.class));
	}

}
