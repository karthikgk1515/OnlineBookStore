package com.bookstore.entity;

import java.time.LocalDate;
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

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	private double price;
	

    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate publishdate;
	
	private int availablebooks;
	

	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "bookid")
	private List<Review> review;
	

	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "bookid")
	private List<OrderInfo> order;
	
	public BookDetails() {
		
	}

	public BookDetails(int bookid, @Size(min = 5, max = 30) String title, @Size(min = 5, max = 64) String author,
			@Size(min = 10, max = 2000) String description, @Size(min = 5, max = 15) String iSBN, double price,
			LocalDate publishdate, int availablebooks, List<Review> review, List<OrderInfo> order) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.description = description;
		this.iSBN = iSBN;
		this.price = price;
		this.publishdate = publishdate;
		this.availablebooks = availablebooks;
		this.review = review;
		this.order = order;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(LocalDate publishdate) {
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

	public List<OrderInfo> getOrder() {
		return order;
	}

	public void setOrder(List<OrderInfo> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "BookDetails [bookid=" + bookid + ", title=" + title + ", author=" + author + ", description="
				+ description + ", iSBN=" + iSBN + ", price=" + price + ", publishdate=" + publishdate
				+ ", availablebooks=" + availablebooks + ", review=" + review + ", order=" + order + "]";
	}

	
}
