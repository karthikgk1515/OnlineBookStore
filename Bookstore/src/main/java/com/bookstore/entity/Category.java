package com.bookstore.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size; 

@Entity
@Table(name="category")
public class Category implements Serializable {
	
	@Id
	@Size(min=5, max=30)
	private String categoryname;
	
	@OneToMany(cascade=CascadeType.ALL )
	@JoinColumn(name="category")
	private List<BookDetails> book=new ArrayList<>();

	public Category() {
		
	}

	public Category(@Size(min = 5, max = 30) String categoryname, List<BookDetails> book) {
		this.categoryname = categoryname;
		this.book = book;
	}

	public String getCategoryame() {
		return categoryname;
	}

	public void setCategoryame(String categoryname) {
		this.categoryname = categoryname;
	}

	public List<BookDetails> getBook() {
		return book;
	}

	public void setBook(List<BookDetails> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Category [categoryname=" + categoryname + ", book=" + book + "]";
	}
	
}
