package com.bookstore.service;

import java.util.List;
import java.util.Set;

import com.bookstore.entity.BookDetails;
import com.bookstore.entity.Category;

public interface CategoryService {

	 Category addCategory(Category category);
	 List<Category> viewCategory();
	 Set<BookDetails> listBook(String category);
}
