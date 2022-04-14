package com.example.purchase.domain;

import java.util.Objects;

public class Book {
	private ISBN isbn;
	private Title title;
	private Author author;
	private Publisher publisher;
	private Edition edition;
	private PublicationYear publicationYear;
	private Price price;
	private Review reviews;
	private Content contents;
	private Photo coverPhoto;
	private Popularity popularity;
	private Category category;

	public static class Builder {
		private ISBN isbn;
		private Title title;
		private Author author;
		private Publisher publisher;
		private Edition edition;
		private PublicationYear publicationYear;
		private Price price;
		private Review reviews;
		private Content contents;
		private Photo coverPhoto;
		private Popularity popularity;
		private Category category;

		public Book build() {
			var book = new Book(this.isbn, this.title, this.author, this.publisher, this.edition, this.publicationYear,
					this.price, this.reviews, this.contents, this.coverPhoto, this.popularity, this.category);
			return book;
		}
	}

	public Book(ISBN isbn, Title title, Author author, Publisher publisher, Edition edition,
			PublicationYear publicationYear, Price price, Review reviews, Content contents, Photo coverPhoto,
			Popularity popularity, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.publicationYear = publicationYear;
		this.price = price;
		this.reviews = reviews;
		this.contents = contents;
		this.coverPhoto = coverPhoto;
		this.popularity = popularity;
		this.category = category;
	}

	public ISBN getIsbn() {
		return isbn;
	}

	public void setIsbn(ISBN isbn) {
		this.isbn = isbn;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public PublicationYear getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(PublicationYear publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Review getReviews() {
		return reviews;
	}

	public void setReviews(Review reviews) {
		this.reviews = reviews;
	}

	public Content getContents() {
		return contents;
	}

	public void setContents(Content contents) {
		this.contents = contents;
	}

	public Photo getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(Photo coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public Popularity getPopularity() {
		return popularity;
	}

	public void setPopularity(Popularity popularity) {
		this.popularity = popularity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		Book other = (Book) obj;
		return Objects.equals(isbn, other.isbn);
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", edition=" + edition + ", publicationYear=" + publicationYear + ", price=" + price + ", reviews="
				+ reviews + ", contents=" + contents + ", coverPhoto=" + coverPhoto + ", popularity=" + popularity
				+ ", category=" + category + "]";
	}

	public Object getStockNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Book of(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
