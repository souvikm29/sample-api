package com.proj.test.sample.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.sample.entity.Books;
import com.proj.sample.repository.BooksRepository;
import com.proj.sample.service.BooksService;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	@Mock
	BooksRepository booksRepository;

	@InjectMocks
	@Autowired
	BooksService booksService;

	@Test
	public void testFindBooksByTitle() {

		when(booksRepository.findById(anyString())).thenReturn(Optional.of(new Books()));
		Optional<Books> booksOptional = booksService.findBooksByTitle("Java book");
		booksOptional.get().setIsbn("857300923712");
		assertThat(booksOptional.get().getIsbn()).isSameAs("857300923712");
	}
}
