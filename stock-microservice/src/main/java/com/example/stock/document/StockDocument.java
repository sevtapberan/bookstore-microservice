package com.example.stock.document;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class StockDocument {
	private String  sku;
	@Id
	private String isbn;
	private String numberOfBooksLeft;
	private String numberOfBooksSold;
	private int basket;
	
	public StockDocument() {
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
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockDocument other = (StockDocument) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "StockDocument [sku=" + sku + ", isbn=" + isbn + ", numberOfBooksLeft=" + numberOfBooksLeft
				+ ", numberOfBooksSold=" + numberOfBooksSold + ", basket=" + basket + "]";
	}
	
	

}
