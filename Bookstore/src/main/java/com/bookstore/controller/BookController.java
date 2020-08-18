package com.bookstore.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.BookDetails;
import com.bookstore.entity.Category;
import com.bookstore.exception.NotFoundException;
import com.bookstore.service.CategoryServiceImpl;
import com.bookstore.service.BookServiceImpl;


@RestController
@CrossOrigin("http://localhost:4200")
public class BookController {

	@Autowired
	BookServiceImpl bookService;
	
	@Autowired
	CategoryServiceImpl categoryService;
	

	static  Logger logger=LoggerFactory.getLogger(BookController.class);
	
	@PostMapping("/addBook/{cname}")
	public ResponseEntity<String> addBook(@PathVariable String cname,@Valid @RequestBody List<BookDetails> books)
	{		 
	try{
		    bookService.addBook(cname, books);
			logger.info("Add book method is accessed");
			return new ResponseEntity<>("Book added successfully", HttpStatus.OK);
			 } catch (DataIntegrityViolationException ex) {
					throw new NotFoundException("ID already exists");
				}
	}
	
	
	@PutMapping("/updateBook")
	public ResponseEntity<String> updateBook(@Valid @RequestBody BookDetails book)
			{
			BookDetails b=bookService.updateBook( book);
			logger.info("Update book method is accessed");
			if(b==null)
				 throw new NotFoundException("Book not found");
			
			return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/removeBook/{bookid}")
	public ResponseEntity<String> removeBook(@PathVariable int bookid)  {
			 bookService.deleteBook(bookid);
			 logger.warn("Delete method is accessed");
			return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getbook")
	public ResponseEntity<List<BookDetails>> listBook() {    
		List<BookDetails> book=bookService.listBook();
		if(book.isEmpty())
			throw new NotFoundException("No books available");
		else
			return new ResponseEntity<>(book, HttpStatus.OK);
			
	}
	
	@GetMapping("/getbook/{bookid}")
	public ResponseEntity<BookDetails> listBook(@PathVariable int bookid){    
		BookDetails book=bookService.viewBook(bookid);
		logger.info("view book with parameter bookid method is accessed");
		if(book==null)
			throw new NotFoundException("No books available ");
		else
			return new ResponseEntity<>(book, HttpStatus.OK);		
	}
	
	@GetMapping("/getBook/{title}")
	public ResponseEntity<Set<BookDetails>> getBook(@PathVariable String title){    
		Set<BookDetails> book=bookService.getBook(title);
		logger.info("view book with parameter bookid method is accessed");
		if(book==null)
			throw new NotFoundException("No books available ");
		else
			return new ResponseEntity<>(book, HttpStatus.OK);		
	}
	
	
	
	
	
	
	@PostMapping("/addCategory")
	public ResponseEntity<String> addCategory(@RequestBody Category category) 
	{
		try{
			categoryService.addCategory(category);
			logger.info("add category method is accessed");
			return new ResponseEntity<>("Category added successfully", HttpStatus.OK);
			 }catch (DataIntegrityViolationException ex) {
					throw new NotFoundException("Category already exists");
				}
	}
	
	@PutMapping("/updateCategory")
	public ResponseEntity<String> updateCategory(@RequestBody Category category) 
	{
		Category c= categoryService.updateCategory(category);
		logger.info("update category method is accessed");
		if(c==null)
			throw new NotFoundException("Category not found");
		else
			return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
	}
	
	
	@DeleteMapping("/removeCategory/{category}")
	public ResponseEntity<String> removeCategory(@PathVariable String category) {
			 categoryService.deleteCategory(category);
			 logger.warn("removecategory method is accessed");
			return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getCategory")
	public ResponseEntity<List<Category>> listCategory(){    
		List<Category> category=categoryService.viewCategory();
		logger.info("view category method is accessed");
		if(category.isEmpty())
			throw new NotFoundException("No categories available ");
		else
			return new ResponseEntity<>(category, HttpStatus.OK);
			
	}
	
	@GetMapping("/viewCategory/{category}")
	public ResponseEntity<Set<BookDetails>> listCategory(@PathVariable String category) {    
	
		Set<BookDetails> book=categoryService.listBook(category);
		logger.info("list book based on category method is accessed");
		if(book.isEmpty())
			throw new NotFoundException("No books available ");
		else
			return new ResponseEntity<>(book, HttpStatus.OK);
			
	}

}
