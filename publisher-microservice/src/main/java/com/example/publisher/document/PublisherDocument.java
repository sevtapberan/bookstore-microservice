package com.example.publisher.document;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publishers")
public class PublisherDocument {
	@Id
	private String publisherId;// ?
	private String publisherName;
	private String publisherLogo;
	@Indexed
	private String requisitionId;
	private String isbn;
	private String author;
	
	public PublisherDocument() {
		
	}

	

	public String getPublisherId() {
		return publisherId;
	}



	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}



	public String getPublisherName() {
		return publisherName;
	}



	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}



	public String getPublisherLogo() {
		return publisherLogo;
	}



	public void setPublisherLogo(String publisherLogo) {
		this.publisherLogo = publisherLogo;
	}



	public String getRequisitionId() {
		return requisitionId;
	}



	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
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
		PublisherDocument other = (PublisherDocument) obj;
		return Objects.equals(publisherId, other.publisherId);
	}

	@Override
	public String toString() {
		return "PublisherDocument [publisherId=" + publisherId + ", publisherName=" + publisherName + ", requisitionId="
				+ requisitionId + ", isbn=" + isbn + ", author=" + author + "]";
	}
	
	
	
	


}
