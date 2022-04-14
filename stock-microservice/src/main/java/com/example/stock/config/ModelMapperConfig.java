package com.example.stock.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.stock.document.StockDocument;
import com.example.stock.domain.Stock;
import com.example.stock.dto.request.DropStockRequest;
import com.example.stock.dto.response.DropStockResponse;
import com.example.stock.dto.response.GetStockLeftResponse;
import com.example.stock.dto.response.GetStockResponse;



@Configuration 
public class ModelMapperConfig {
	private static final Converter<Stock, GetStockResponse>
    STOCK_TO_GET_STOCK_RESPONSE_CONVERTER = 
(context) -> {
   var stock = context.getSource();
   var response = new GetStockResponse();
   response.setSku(stock.getSku().getValue());
   response.setIsbn(stock.getIsbn().getValue());
   System.err.println("STOCK_TO_GET_STOCK_RESPONSE_CONVERTER: "+response);
   return response;
};
	
private static final Converter<Stock, GetStockLeftResponse>
STOCK_TO_GET_STOCK_LEFT_RESPONSE_CONVERTER = 
(context) -> {
	  var stock = context.getSource();
	   var response = new GetStockLeftResponse();
	   response.setSku(stock.getSku().getValue());
	   response.setIsbn(stock.getIsbn().getValue());
	   
	
	return response;
};

private static final Converter<Stock, DropStockResponse>
STOCK_TO_DROP_STOCK_RESPONSE_CONVERTER = 
(context) -> {
	 var stock = context.getSource();
	   var response = new DropStockResponse();
	   response.setIsbn(stock.getIsbn().getValue());
	   response.setBasket(stock.getBasket().getValue());
	   
	
	return response;
};

private static final Converter<DropStockRequest, Stock>
DROP_STOCK_REQUEST_TO_STOCK_CONVERTER = 
(context) -> {
	var request = context.getSource();
	return new Stock.Builder()
			           .sku(request.getSku())
			           .isbn(request.getIsbn())
			           .basket(request.getBasket())
			           .build();
};

private static final Converter<StockDocument, Stock>
STOCK_DOCUMENT_TO_STOCK_CONVERTER = 
(context) -> {
	var document = context.getSource();
	return new Stock.Builder()
	           .sku(document.getSku())
	           .isbn(document.getIsbn())
	           .basket(document.getBasket())
	           .build();
};

private static final Converter<Stock, StockDocument>
STOCK_TO_STOCK_DOCUMENT_CONVERTER = 
(context) -> {
	var stock = context.getSource();
	var stockDocument = new StockDocument();
		stockDocument.setIsbn(stock.getIsbn().getValue());
		stockDocument.setBasket(stock.getBasket().getValue());  
	   return stockDocument;
};

@Bean
public ModelMapper modelMapper() {
	var mapper = new ModelMapper();
	mapper.addConverter(STOCK_TO_STOCK_DOCUMENT_CONVERTER, 
			Stock.class, StockDocument.class);
	mapper.addConverter(STOCK_DOCUMENT_TO_STOCK_CONVERTER , 
			StockDocument.class, Stock.class);
	mapper.addConverter(STOCK_TO_GET_STOCK_RESPONSE_CONVERTER, 
			Stock.class, GetStockResponse.class);
	mapper.addConverter(STOCK_TO_GET_STOCK_LEFT_RESPONSE_CONVERTER , 
			Stock.class, GetStockLeftResponse.class);
	mapper.addConverter(STOCK_TO_DROP_STOCK_RESPONSE_CONVERTER, 
			Stock.class, DropStockResponse.class);
	mapper.addConverter(DROP_STOCK_REQUEST_TO_STOCK_CONVERTER, 
			DropStockRequest.class, Stock.class);
	return mapper;
}

}
