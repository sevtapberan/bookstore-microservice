package com.example.publisher.domain;

public final class Author {
	private final String author;

	public Author(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Author [author=" + author + "]";
	}
	
	
	
	

}
