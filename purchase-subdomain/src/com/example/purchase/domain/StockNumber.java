package com.example.purchase.domain;

public class StockNumber {
	public  final StockNumber EMPTY = new StockNumber(0);
	private  int value;

	private StockNumber(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static StockNumber of(int value) {
		if (value < 0)
			throw new IllegalArgumentException("Stock number should be a positive value");
		return new StockNumber(value);
	}

	@Override
	public String toString() {
		return "StockNumber [value=" + value + "]";
	}

	public StockNumber add(int item) {
		return StockNumber.of(value + item);
	}

	public StockNumber drop(int soldItems) {
		return StockNumber.of(value - soldItems);
	}

	public boolean isLessThan(StockNumber other) {
		return this.value < other.value;
	}

	public boolean isLessThanSellNumber(SellNumber other) {
		return this.value < other.getValue();
	}

}