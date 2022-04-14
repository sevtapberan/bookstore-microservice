package com.example.bookcatalog.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.bookcatalog.domain.Category;
import com.example.bookcatalog.validation.Isbn;

public class AddBookRequest {
	@Isbn
	private String isbn;
	@NotBlank
	private String title;
	@NotBlank
	private String author;
	@NotBlank
	private String publisher;
	@Min(1)
	private int edition;
	@Min(1800)
	private int publicationYear;
	@Min(1)
	private double price;
	private String reviews;
	private String contents;
	private String photo;
	private int popularity;
	private Category category;

	public AddBookRequest() {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "AddBookRequest [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", publicationYear=" + publicationYear + ", price=" + price + ", reviews="
				+ reviews + ", contents=" + contents + ", photo=" + photo + ", popularity=" + popularity + ", category="
				+ category + "]";
	}

}
