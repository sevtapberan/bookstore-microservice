package com.example.publisher.domain;

import java.util.Objects;

public class Publisher {
	private PublisherId publisherId;
	private PublisherName publisherName;
	private PublisherLogo publisherLogo;
	private RequisitionId requisitionId;
	private Isbn isbn;
	private Author author;

	public static class Builder {
		private PublisherId publisherId;// ?
		private PublisherName publisherName;
		private PublisherLogo publisherLogo;
		private RequisitionId requisitionId;
		private Isbn isbn;
		private Author author;

		public Builder publisherName(String name) {
			this.publisherName = PublisherName.of(name);
			return this;
		}

		public Builder publisherLogo(byte[] values) {
			this.publisherLogo = PublisherLogo.valueOf(values);
			return this;
		}

		public Builder publisherLogo(String base64Values) {
			this.publisherLogo = PublisherLogo.valueOf(base64Values);
			return this;
		}

		public Builder isbn(String value) {
			this.isbn = Isbn.of(value);
			return this;
		}
		public Publisher build() {
			// Validation
			var publisher = new Publisher(this.publisherId);//bunun setter ı olmadığı için
			publisher.setPublisherName(publisherName);
			publisher.setPublisherLogo(publisherLogo);
			publisher.setIsbn(isbn);
			publisher.setAuthor(author);
			publisher.setRequisitionId(requisitionId);
			
			return publisher;
		}

	}

	public Publisher(PublisherId publisherId) {
		this.publisherId = publisherId;
		
	
	}
	
	

	public PublisherName getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(PublisherName publisherName) {
		this.publisherName = publisherName;
	}

	public PublisherLogo getPublisherLogo() {
		return publisherLogo;
	}

	public void setPublisherLogo(PublisherLogo publisherLogo) {
		this.publisherLogo = publisherLogo;
	}

	public Isbn getIsbn() {
		return isbn;
	}

	public void setIsbn(Isbn isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public PublisherId getPublisherId() {
		return publisherId;
	}

	public void setRequisitionId(RequisitionId requisitionId) {
		this.requisitionId = requisitionId;
	}



	public RequisitionId getRequisitionId() {
		return requisitionId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(publisherId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		return Objects.equals(publisherId, other.publisherId);
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherLogo="
				+ publisherLogo + ", requisitionId=" + requisitionId + ", isbn=" + isbn + ", author=" + author + "]";
	}

}
