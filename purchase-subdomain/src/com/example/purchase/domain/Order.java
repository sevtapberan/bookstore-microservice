package com.example.purchase.domain;

import java.util.Objects;

public class Order {
	private final OrderId orderId;
	private Book book;
	private Customer customer;

	public Order(OrderId orderId) {
		this.orderId = orderId;
	}

	private Order(OrderId orderId, Book book, Customer customer) {
		this.orderId = orderId;
		this.book = book;
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderId getOrderId() {
		return orderId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(orderId, other.orderId);
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", book=" + book + ", customer=" + customer + "]";
	}

	public static class Builder {
		private OrderId orderId;
		private Book book;
		private Customer customer;

		public Builder orderId(String value) {
			this.orderId = OrderId.of(value);
			return this;
		}

		public Builder book(String value) {
			this.book = Book.of(value);
			return this;
		}

		public Builder customer(String value) {
			this.customer = Customer.of(value);
			return this;
		}

		public Order build() {
			var order = new Order(orderId, book, customer);
			return order;
		}

	}

}
