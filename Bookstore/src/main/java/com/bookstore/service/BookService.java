package com.bookstore.service;


import java.util.List;

import com.bookstore.entity.BookDetails;

public interface BookService {
	
	 List<BookDetails> addBook(String cname, List<BookDetails> book) ;
	 BookDetails updateBook(BookDetails book);
	 void  deleteBook(int bookid);
	 List<BookDetails> listBook();
	 BookDetails viewBook(int bookid);


}
