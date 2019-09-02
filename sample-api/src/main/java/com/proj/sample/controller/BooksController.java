package com.proj.sample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.sample.entity.Books;
import com.proj.sample.service.BooksService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BooksController {

	private final BooksService booksService;

	public BooksController(BooksService booksService) {
		this.booksService = booksService;
	}

	@GetMapping("/find-by-title")
	private Books getBooksByTitle(@RequestParam String title) {
		log.info("In BooksController method getBooksByTitle : START");
		Books books = booksService.findBooksByTitle(title).get();
		log.info("In BooksController method getBooksByTitle : END");
		return books;
	}

	@GetMapping("/find-all")
	private List<Books> getAllBooks() {
		log.info("In BooksController method getAllBooks : START");
		List<Books> books = booksService.findAll();
		log.info("In BooksController method getAllBooks : END");
		return books;
	}
}
