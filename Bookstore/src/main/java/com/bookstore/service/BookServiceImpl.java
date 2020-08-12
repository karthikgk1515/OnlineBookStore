package com.bookstore.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.BookDetails;
import com.bookstore.entity.Category;
import com.bookstore.exception.NotFoundException;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;

@Transactional
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository br;
	
	@Autowired
	CategoryRepository cr;
	

	static  Logger logger=LoggerFactory.getLogger(BookServiceImpl.class);
	@Override
	public List<BookDetails> addBook(String cname, List<BookDetails> book)  {
		for(BookDetails b:book) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
		try {
		 sdf.parse(b.getPublishdate());
		} catch (ParseException e) {
			e.getStackTrace();
		}}
		Category c= cr.findById(cname).get();
		if(c==null)
		{
			throw new NotFoundException("Category not found");
		}
		else
		{
			List<BookDetails> b1= br.saveAll(book);
			c.setBook(b1);
			return b1;
		}
			
	}
	@Override
	public BookDetails updateBook(BookDetails book){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
		try {
		 sdf.parse(book.getPublishdate());
		} catch (ParseException e) {
			logger.warn("exception raised",e);
		}
	BookDetails b=br.findById(book.getBookid()).get();
	if(b==null)
		throw new NotFoundException("Book not found");

		b.setAuthor(book.getAuthor());
		b.setAvailablebooks(book.getAvailablebooks());
		b.setDescription(book.getDescription());
		b.setImage(book.getImage());
		b.setiSBN(book.getiSBN());
		b.setPrice(book.getPrice());
		b.setPublishdate(book.getPublishdate());
		b.setReview(book.getReview());
		b.setTitle(book.getTitle());
		
		return br.save(b);
	}

	@Override
	public void deleteBook(int bookid) {
		 br.deleteById(bookid);
	}
	
	@Override
	public List<BookDetails> listBook() {
	 return br.findAll();
	}
	
	@Override
	public BookDetails viewBook(int bookid) {
		return br.findById(bookid).get();
	}
	

}
