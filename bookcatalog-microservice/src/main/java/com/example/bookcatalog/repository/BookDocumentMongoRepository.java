package com.example.bookcatalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.bookcatalog.document.BookDocument;
import com.example.bookcatalog.domain.Category;

public interface BookDocumentMongoRepository extends MongoRepository<BookDocument, String> {

	Optional<BookDocument> findByIsbn(String isbn);

	List<BookDocument> findAllByCategory(Category category);
	
	List<BookDocument> findByTitleLike(String title);

}
