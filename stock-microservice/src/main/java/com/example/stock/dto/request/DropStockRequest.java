package com.example.stock.dto.request;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class DropStockRequest {
	@NotBlank
	private String  sku;
	@Id
	private String isbn;
	private String numberOfBooksLeft;
	private String numberOfBooksSold;
	@NotBlank
	private int basket;
	
	public DropStockRequest() {
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumberOfBooksLeft() {
		return numberOfBooksLeft;
	}

	public void setNumberOfBooksLeft(String numberOfBooksLeft) {
		this.numberOfBooksLeft = numberOfBooksLeft;
	}

	public String getNumberOfBooksSold() {
		return numberOfBooksSold;
	}

	public void setNumberOfBooksSold(String numberOfBooksSold) {
		this.numberOfBooksSold = numberOfBooksSold;
	}

	public int getBasket() {
		return basket;
	}

	public void setBasket(int basket) {
		this.basket = basket;
	}

	@Override
	public String toString() {
		return "DropStockRequest [sku=" + sku + ", isbn=" + isbn + ", numberOfBooksLeft=" + numberOfBooksLeft
				+ ", numberOfBooksSold=" + numberOfBooksSold + ", basket=" + basket + "]";
	}
	
	
	

}
