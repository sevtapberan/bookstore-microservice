package com.example.stock.domain;

import java.util.Objects;

public class Stock {
	private final StockKeepingUnit sku;
	private final Isbn isbn;
	private StockNumber numberOfBooksLeft = StockNumber.EMPTY;
	private SellNumber numberOfBooksSold = SellNumber.EMPTY;
	private Basket basket;
	
	private Stock(StockKeepingUnit sku, Isbn isbn, Basket basket) {
		this(sku, isbn, StockNumber.EMPTY, SellNumber.EMPTY, basket);
	}

	private Stock(StockKeepingUnit sku, Isbn isbn, StockNumber numberOfBooksLeft, SellNumber numberOfBooksSold,Basket basket) {
		this.sku = sku;
		this.isbn = isbn;
		this.numberOfBooksLeft = numberOfBooksLeft;
		this.numberOfBooksSold = numberOfBooksSold;
		this.basket = basket;
	}

	public StockKeepingUnit getSku() {
		return sku;
	}

	public Isbn getIsbn() {
		return isbn;
	}

	public StockNumber getNumberOfBooksLeft() {
		return numberOfBooksLeft;
	}

	public SellNumber getNumberOfBooksSold() {
		return numberOfBooksSold;
	}
	

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public StockNumber addStock(int newItems) {
		this.numberOfBooksLeft = numberOfBooksLeft.add(newItems);
		return numberOfBooksLeft;
	}

	public StockNumber sellFromStock(int soldItems) {
		this.numberOfBooksLeft = numberOfBooksLeft.drop(soldItems);
		numberOfBooksSold = numberOfBooksSold.add(soldItems);
		return numberOfBooksLeft;
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(sku);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(sku, other.sku);
	}

	@Override
	public String toString() {
		return "Stock [sku=" + sku + ", isbn=" + isbn + ", numberOfBooksLeft=" + numberOfBooksLeft
				+ ", numberOfBooksSold=" + numberOfBooksSold + "]";
	}

	public static class Builder {
		private StockKeepingUnit sku;
		private Isbn isbn;
		private StockNumber numberOfBooksLeft;
		private SellNumber numberOfBooksSold;
		private Basket basket;

		public Builder sku(String value) {
			this.sku = StockKeepingUnit.of(value);
			return this;
		}

		public Builder isbn(String value) {
			this.isbn = Isbn.of(value);
			return this;
		}

		public Builder numberOfBooksLeft(int value) {
			this.numberOfBooksLeft = StockNumber.of(value);
			return this;
		}

		public Builder numberOfBooksSold(int value) {
			this.numberOfBooksSold = SellNumber.of(value);
			return this;
		}
		public Builder basket(int value) {
			this.basket = basket.of(value);
			return this;
		}

		public Stock build() {
			var stock = new Stock(sku, isbn, numberOfBooksLeft, numberOfBooksSold, basket);

			return stock;
		}
	}

}
