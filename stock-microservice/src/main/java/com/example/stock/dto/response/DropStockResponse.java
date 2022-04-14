package com.example.stock.dto.response;

public class DropStockResponse {

	private String isbn;
	private int basket;
	
	public DropStockResponse() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getBasket() {
		return basket;
	}

	public void setBasket(int basket) {
		this.basket = basket;
	}

	@Override
	public String toString() {
		return "DropStockResponse [isbn=" + isbn + ", basket=" + basket + "]";
	}
	
	
}
