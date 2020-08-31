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
		
			br.saveAll(books);
			List<BookDetails> b1=c.getBook();
			b1.addAll(books);
			return books;
		
			
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
