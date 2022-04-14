package com.example.stock.dto.response;

public class GetStockResponse {
	private String  sku;
	private String isbn;
	private String numberOfBooksLeft;
	private String numberOfBooksSold;
	private int basket;
	
	public GetStockResponse() {
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
		return "GetStockResponse [sku=" + sku + ", isbn=" + isbn + ", numberOfBooksLeft=" + numberOfBooksLeft
				+ ", numberOfBooksSold=" + numberOfBooksSold + ", basket=" + basket + "]";
	}
	
	

}
