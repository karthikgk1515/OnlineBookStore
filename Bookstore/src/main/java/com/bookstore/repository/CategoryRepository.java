package com.bookstore.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
	
	@Query("select c.categoryname from Category c")
	List<String> findByCategory();


}
