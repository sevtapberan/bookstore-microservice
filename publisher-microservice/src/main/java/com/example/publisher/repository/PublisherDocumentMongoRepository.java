package com.example.publisher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.publisher.document.PublisherDocument;

public interface PublisherDocumentMongoRepository extends MongoRepository<PublisherDocument, String>{

}
