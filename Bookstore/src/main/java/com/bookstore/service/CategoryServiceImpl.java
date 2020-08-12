package com.bookstore.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.entity.BookDetails;
import com.bookstore.entity.Category;
import com.bookstore.exception.NotFoundException;
import com.bookstore.repository.CategoryRepository;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository cr;
	
	@Override
	public Category addCategory(Category cat)
	{
		return cr.save(cat);
	}
	
	@Override
	public Category updateCategory(Category category)  {
		Category c= cr.findById(category.getCategoryame()).get();
		if(c!=null)
		{
			c.setCategoryame(category.getCategoryame());
			return c;
		}
		else
			throw new NotFoundException("Category not found");
	}

	 
	@Override
	public void deleteCategory(String cname)
	{
		cr.deleteById(cname);
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
		return b;
	}
}
