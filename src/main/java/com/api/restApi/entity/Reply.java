package com.api.restApi.entity;

import javax.persistence.Entity;
//import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Reply {
	@Id
	private String replyID;
	private String reviewID;
	private String replySection;
	private String user_email;
	private String replySubject;

	public Reply() {
	}

	public String getReplyID() {
		return replyID;
	}

	public void setReplyID(String replyID) {
		this.replyID = replyID;
	}

	public String getReviewID() {
		return reviewID;
	}

	public void setReviewID( String reviewID) {
		this.reviewID = reviewID;
	}

	public String getReplySection() {
		return replySection;
	}

	public void setReplySection(String replySection) {
		this.replySection = replySection;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getReplySubject() {
		return replySubject;
	}

	public void setReplySubject(String replySubject) {
		this.replySubject = replySubject;
	}
}
