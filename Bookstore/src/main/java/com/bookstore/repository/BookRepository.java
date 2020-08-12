package com.bookstore.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.BookDetails;

@Repository
public interface BookRepository extends JpaRepository<BookDetails, Integer> {
	
	

}
