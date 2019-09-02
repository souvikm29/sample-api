package com.proj.sample.service;

import static com.proj.sample.constants.SampleApiConstants.NO_RECORDS_FOUND;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.proj.sample.entity.Books;
import com.proj.sample.exception.BooksNotFoundException;
import com.proj.sample.repository.BooksRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BooksService {

	private final BooksRepository booksRepository;

	public BooksService(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	public void saveAll(List<Books> books) {
		log.info("In BooksService method saveAll : START");
		booksRepository.saveAll(books);
		log.info("In BooksService method saveAll : END");
	}

	public Optional<Books> findBooksByTitle(String title) {
		log.info("In BooksService method findBooksByTitle : START");
		Optional<Books> booksOptional = booksRepository.findById(title);
		if (!ObjectUtils.isEmpty(booksOptional)) {
			log.info("In BooksService method findBooksByTitle : END");
			return booksOptional;
		} else {
			log.error("No Book found for titile :" + title);
			throw new BooksNotFoundException(NO_RECORDS_FOUND);
		}
	}

	public List<Books> findAll() {
		log.info("In BooksService method findAll : START");
		List<Books> books = (List<Books>) booksRepository.findAll();
		if (!ObjectUtils.isEmpty(books)) {
			log.info("In BooksService method findAll : END");
			return books;
		} else {
			log.error("No Record Found");
			throw new BooksNotFoundException(NO_RECORDS_FOUND);
		}
	}
}
