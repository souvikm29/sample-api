package com.proj.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proj.sample.entity.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, String> {
	
}
