package com.bookstore.repository;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.BookDetails;

@Repository
public interface BookRepository extends JpaRepository<BookDetails, Integer> {

	@Query("select b.title from BookDetails b")
	List<String> findByTitle();

	@Query("select b from BookDetails b where b.title=?1")
	Set<BookDetails> findByBook(String c1);
	
	

}
