package com.bookstore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.BookDetails;
import com.bookstore.entity.Category;
import com.bookstore.exception.NotFoundException;
import com.bookstore.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository cr;
	
	@Override
	public Category addCategory(Category cat)
	{
		return cr.save(cat);
	}
	
	@Override
	public List<Category> viewCategory()
	{
		return cr.findAll();
	}
	
	@Override
	public Set<BookDetails> listBook(String category)
	{
		Set<BookDetails> b=new HashSet<>();
		String[] book= category.split(" ");
		for(String s:book)
		{
			List<String> cname=cr.findByCategory();
			for(String c1:cname)
			{
				if(c1.equalsIgnoreCase(s))
				{
			Category c= cr.findById(c1).get();
			b.addAll(c.getBook());
			}
			}
		}
		if(b.isEmpty())
			 throw new NotFoundException("No books available in this category");
		
			return b;
	}
}
