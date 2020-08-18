package com.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size; 

@Entity
@Table(name="customerreview")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewno")
	@SequenceGenerator(sequenceName = "review_id", allocationSize = 10, name = "reviewno")
	private int reviewno;
	
	private int rating;
	 
	@Size(min=10, max=128)
	private String headline;
	
	@Size(min=100)
	private String comments;
	

	public Review() {
		
	}


	public Review(int reviewno, int rating, @Size(min = 10, max = 128) String headline,
			@Size(min = 100) String comments) {
		
		this.reviewno = reviewno;
		this.rating = rating;
		this.headline = headline;
		this.comments = comments;
	}


	public int getReviewno() {
		return reviewno;
	}


	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getHeadline() {
		return headline;
	}


	public void setHeadline(String headline) {
		this.headline = headline;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Review [reviewno=" + reviewno + ", rating=" + rating + ", headline=" + headline + ", comments="
				+ comments + "]";
	}




	
}
