package com.example.publisher.dto.response;

public class RequisitionCancelResponse {

	private String publisherId;// ?
	private String publisherName;
	private String publisherLogo;
	private String requisitionId;
	private String isbn;
	private String author;
	
	
	public RequisitionCancelResponse() {
		super();
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
	public String toString() {
		return "GetBookResponse [publisherId=" + publisherId + ", publisherName=" + publisherName + ", requisitionId="
				+ requisitionId + ", isbn=" + isbn + ", author=" + author + "]";
	}
}
