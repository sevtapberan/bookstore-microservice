package com.example.bookcatalog.dto.response;

public class AddBookResponse {
	private String isbn;
	private String title;

	public AddBookResponse() {
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "AddBookResponse [isbn=" + isbn + ", title=" + title + "]";
	}

}
