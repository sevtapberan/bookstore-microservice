package com.example.bookcatalog.exercise;

import com.example.bookcatalog.domain.Book;

public class ExerciseBuilder {

	public static void main(String[] args) {
		
		var book = new Book.Builder().isbn("24324").title(null).author("John").publisher(null).edition(1).publicationYear(1970)
				.price(1).reviews(null).contents(null).coverPhoto(null).popularity(0).category("History").build();
		System.err.println(book);
	}

}
