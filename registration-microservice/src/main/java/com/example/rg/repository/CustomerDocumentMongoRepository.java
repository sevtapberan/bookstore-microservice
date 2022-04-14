package com.example.rg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.rg.document.CustomerDocument;

public interface CustomerDocumentMongoRepository extends MongoRepository <CustomerDocument,String> {

}
