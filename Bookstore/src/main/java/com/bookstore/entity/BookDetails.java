package com.bookstore.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="BookDetails")
public class BookDetails{
	 @Id
     @Column(name="bookId")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
     @SequenceGenerator(sequenceName = "book_sequence", allocationSize = 1, name = "book_seq")
	 private int bookid;
	@Size(min=5, max=30)
	private String title;
	@Size(min=5, max=64)
	private String author;
	@Size(min=10, max=2000)
	private String description;
	@Size(min=5, max=15)
	private String iSBN;
	private byte[] image;
	
	private double price;
	
	private String publishdate;
	
	private int availablebooks;
	

	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookid")
	private List<Review> review;
	
	public BookDetails() {
		
	}

	public BookDetails(int bookid, @Size(min = 5, max = 30) String title, @Size(min = 5, max = 64) String author,
			@Size(min = 200, max = 2000) String description, @Size(min = 10, max = 15) String iSBN, byte[] image,
			 double price, String publishdate, int availablebooks, List<Review> review) {
		
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.description = description;
		this.iSBN = iSBN;
		this.image = image;
		this.price = price;
		this.publishdate = publishdate;
		this.availablebooks = availablebooks;
		this.review = review;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public int getAvailablebooks() {
		return availablebooks;
	}

	public void setAvailablebooks(int availablebooks) {
		this.availablebooks = availablebooks;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "BookDetails [bookid=" + bookid + ", title=" + title + ", author=" + author + ", description="
				+ description + ", iSBN=" + iSBN + ", image=" + Arrays.toString(image) + ", price=" + price
				+ ", publishdate=" + publishdate + ", availablebooks=" + availablebooks + ", review=" + review + "]";
	}
	
	
}