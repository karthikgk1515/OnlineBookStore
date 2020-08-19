package com.bookstore.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bookstore.entity.BookDetails;
import com.bookstore.entity.Category;
import com.bookstore.entity.Review;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class BookServiceImplTest {

		@Mock
		BookRepository bdao;
	
		@Mock
		CategoryRepository cdao;
		
		@Autowired
		BookServiceImpl bookService;
		
		@Autowired
		CategoryServiceImpl categoryService;
		
		@Before
		public void init()
		{
			MockitoAnnotations.initMocks(this);
		}
		
		@Test
		public void addBook() {
			List<Review> review=new ArrayList<>();
			Review r1= new Review(101,4,"Great start to a new series","Great Book");
			Review r2=new Review(102, 5, "I read this in the stock room at work because I couldn’t put it down"," Nice book");
			review.add(r1);
			review.add(r2);
			List<BookDetails> book=new ArrayList<>();
			BookDetails book1=new BookDetails(24,"Aeronautics","Paul Rudd","Aeronautical engineering"," 978-3-16-148410-0",800,LocalDate.parse("2020-09-08",DateTimeFormatter.ofPattern("dd/MM/yyyy")),200,review,null);
			book.add(book1);
			assertEquals(24,book.get(0).getBookid());
		}
		
		@Test
		public void addBook_neg() {
			List<Review> review=new ArrayList<>();
			Review r1= new Review(101,4,"Great start to a new series","Great Book");
			Review r2=new Review(102, 5, "I read this in the stock room at work because I couldn’t put it down"," Nice book");
			review.add(r1);
			review.add(r2);
			List<BookDetails> book=new ArrayList<>();
			BookDetails book1=new BookDetails(24,"Aeronautics","Paul Rudd","Aeronautical engineering"," 978-3-16-148410-0",800,LocalDate.parse("2020-09-08",DateTimeFormatter.ofPattern("dd/MM/yyyy")),200,review,null);
			book.add(book1);
			assertEquals(26,book.get(0).getBookid());
		}
		
		@Test
		public void updateBook() {
			BookDetails b=new BookDetails();
			List<Review> review=new ArrayList<>();
			Review r1= new Review(101,4,"Great start to a new series","Great Book");
			Review r2=new Review(102, 5, "I read this in the stock room at work because I couldn’t put it down"," Nice book");
			review.add(r1);
			review.add(r2);
			b.setBookid(23);
			b.setAuthor("Paul Rudd");
			b.setAvailablebooks(200);
			b.setDescription("Aeronautical engineering");
			b.setiSBN("978-3-16-148410-0");
			b.setPrice(800);
			b.setPublishdate(LocalDate.parse("2020-09-08",DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			b.setReview(review);
			b.setTitle("Aeronautics");
			assertEquals("Paul Rudd", b.getAuthor());
		}
		@Test
		public void deleteBook() {
			List<Review> review=new ArrayList<>();
			Review r1= new Review(101,4,"Great start to a new series","Great Book");
			Review r2=new Review(102, 5, "I read this in the stock room at work because I couldn’t put it down"," Nice book");
			review.add(r1);
			review.add(r2);
			BookDetails book=new BookDetails(24,"Aeronautics","Paul Rudd","Aeronautical engineering"," 978-3-16-148410-0",800,LocalDate.parse("2020-09-08",DateTimeFormatter.ofPattern("dd/MM/yyyy")),200,review,null);
			bdao.deleteById(24);
	        verify(bdao,times(1)).deleteById(24);
		}
		
		@Test
		public void listBook()
		{
			List<Review> review=new ArrayList<>();
			Review r1= new Review(101,4,"Great start to a new series","Great Book");
			Review r2=new Review(102, 5, "I read this in the stock room at work because I couldn’t put it down"," Nice book");
			review.add(r1);
			review.add(r2);
			List<BookDetails> book=new ArrayList<>();
			BookDetails book1=new BookDetails(24,"Aeronautics","Paul Rudd","Aeronautical engineering"," 978-3-16-148410-0",800,LocalDate.parse("2020-09-08",DateTimeFormatter.ofPattern("dd/MM/yyyy")),200,review,null);
			book.add(book1);
			bookService.listBook();
			assertEquals(1,book.size());
		}
		
		@Test
		public void listBook_neg()
		{
			List<Review> review=new ArrayList<>();
			Review r1= new Review(101,4,"Great start to a new series","Great Book");
			Review r2=new Review(102, 5, "I read this in the stock room at work because I couldn’t put it down"," Nice book");
			review.add(r1);
			review.add(r2);
			List<BookDetails> book=new ArrayList<>();
			BookDetails book1=new BookDetails(24,"Aeronautics","Paul Rudd","Aeronautical engineering"," 978-3-16-148410-0",800,LocalDate.parse("2020-09-08",DateTimeFormatter.ofPattern("dd/MM/yyyy")),200,review,null);
			book.add(book1);
			bookService.listBook();
			assertEquals(2,book.size());
		}
	
		@Test
		 void addCategoryTest() {
			
			Category c=new Category("Horror",null);
			categoryService.addCategory(c);
			assertEquals("Horror",c.getCategoryame());
		}
		
		@Test
		 void addCategoryTest_neg(){
			
			Category c=new Category("Horror",null);
			categoryService.addCategory(c);
			assertEquals("Comedy",c.getCategoryame());
		}

		@Test
		 void getAllCategoryTest(){
				List<Category> CategoryList = new ArrayList<Category>();
			    CategoryList.add(new Category("Horror",null));
				CategoryList.add(new Category("Thriller ",null));
				when(cdao.findAll()).thenReturn(CategoryList);
				List<Category> result = categoryService.viewCategory();
				assertEquals(3, result.size());
			}
		
		@Test
		 void getAllCategoryTest_neg(){
				List<Category> CategoryList = new ArrayList<Category>();
			    CategoryList.add(new Category("Horror",null));
				CategoryList.add(new Category("Thriller ",null));
				when(cdao.findAll()).thenReturn(CategoryList);
				List<Category> result = categoryService.viewCategory();
				assertEquals(5, result.size());
			}
		
		  

				 @Test
				  void removeCategoryTest(){
				 Category c=new Category("horror",null);
				 cdao.deleteById(c.getCategoryame());
			        verify(cdao,times(1)).deleteById(c.getCategoryame());
				 }
				 

}
