package com.example.bookcatalog.domain;

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

		public Builder isbn(String value) {
			this.isbn = ISBN.of(value);
			return this;
		}

		public Builder title(String value) {
			this.title = Title.of(value);
			return this;
		}

		public Builder author(String value) {
			this.author = Author.of(value);
			return this;
		}

		public Builder publisher(String value) {
			this.publisher = Publisher.of(value);
			return this;
		}

		public Builder edition(int value) {
			this.edition = Edition.of(value);
			return this;
		}

		public Builder publicationYear(int value) {
			this.publicationYear = PublicationYear.of(value);
			return this;
		}

		public Builder price(double value) {
			this.price = Price.of(value);
			return this;
		}

		public Builder reviews(String value) {
			this.reviews = Review.of(value);
			return this;
		}

		public Builder contents(String value) {
			this.contents = Content.of(value);
			return this;
		}

		public Builder coverPhoto(String value) {
			this.coverPhoto = Photo.of(value);
			return this;
		}

		public Builder popularity(int value) {
			this.popularity = Popularity.of(value);
			return this;
		}

		public Builder category(String value) {
			this.category = Category.valueOf(value);
			return this;
		}

		public Book build() {
			var book = new Book(this.isbn, this.title, this.author, this.publisher, this.edition, this.publicationYear,
					this.price, this.reviews, this.contents, this.coverPhoto, this.popularity, this.category);
			book.setIsbn(isbn);
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setEdition(edition);
			book.setPublicationYear(publicationYear);
			book.setPrice(price);
			book.setReviews(reviews);
			book.setContents(contents);
			book.setCoverPhoto(coverPhoto);
			book.setPopularity(popularity);
			book.setCategory(category);
			return book;
		}
	}

	public Book(ISBN isbn, Title title, Author author, Publisher publisher, Edition edition,
			PublicationYear publicationYear, Price price, Review reviews, Content contents, Photo coverPhoto,
			Popularity popularity, Category category) {
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

}
