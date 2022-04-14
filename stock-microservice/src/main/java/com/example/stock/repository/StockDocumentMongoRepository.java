package com.example.stock.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.stock.document.StockDocument;

public interface StockDocumentMongoRepository extends MongoRepository<StockDocument,String> {

}
