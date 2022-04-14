package com.example.publisher.dto.response;

public class RequisitionApproveResponse {

	
	private String publisherName;
	private String requisitionId;
	private String isbn;
	
	
	

	public RequisitionApproveResponse() {
		
	}


	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
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


	@Override
	public String toString() {
		return "RequisitionApproveResponse [publisherName=" + publisherName + ", requisitionId=" + requisitionId
				+ ", isbn=" + isbn + "]";
	}





	
}
