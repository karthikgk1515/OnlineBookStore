package com.bookstore.service;


import java.util.List;
import java.util.Set;


import com.bookstore.entity.BookDetails;

public interface BookService {
	
	 List<BookDetails> addBook(String cname, List<BookDetails> book) ;
	 List<BookDetails> listBook();
	 Set<BookDetails> getBook(String title);
}
