package com.bookstore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public List<BookDetails> addBook(String cname, List<BookDetails> books)  {
		Category c= cr.findById(cname).get();
		if(c==null)
		{
			throw new NotFoundException("Category not found");
		}
		else
		{
			br.saveAll(books);
			List<BookDetails> b1=c.getBook();
			b1.addAll(books);
			return books;
		}
			
	}
	@Override
	public BookDetails updateBook(BookDetails book){
	BookDetails b=br.findById(book.getBookid()).get();
	if(b==null)
		throw new NotFoundException("Book not found");

		b.setAuthor(book.getAuthor());
		b.setAvailablebooks(book.getAvailablebooks());
		b.setDescription(book.getDescription());
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
	public Set<BookDetails> getBook(String title)
	{
		Set<BookDetails> b=new HashSet<>();
		List<String> titles=br.findByTitle();
			for(String c1:titles)
			{
				if(c1.equalsIgnoreCase(title))
				{
					b.addAll(br.findByBook(c1));
			}
			}
		if(b.isEmpty())
			throw new NotFoundException("book not found");
		return b;
	}
	

}
