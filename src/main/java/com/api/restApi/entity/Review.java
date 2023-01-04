package com.api.restApi.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	private String reviewID;
	private String subject;
	private String productID;

	private String description;

	public Review() {}

	public String getReviewID() {
		return reviewID;
	}

	public void setCommentID(String reviewID) {
		this.reviewID = reviewID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

   public  String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}



}
