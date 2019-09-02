package com.proj.sample;

import static com.proj.sample.constants.SampleApiConstants.UNABLE_READ_EXCEPTION_MESSAGE;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proj.sample.entity.Books;
import com.proj.sample.exception.UnableToReadJsonException;
import com.proj.sample.service.BooksService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Method to read test.json and write to database.
	@Bean
	CommandLineRunner runner(BooksService booksService) {
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			TypeReference<List<Books>> typeReference = new TypeReference<List<Books>>() {
			};
			log.info("In Command Line Runner : START");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/test.json");
			try {
				List<Books> books = objectMapper.readValue(inputStream, typeReference);
				booksService.saveAll(books);
				log.info("Successfully Saved to Database");
			} catch (IOException ex) {
				log.error("Some error occurred while reading the JSON file");
				throw new UnableToReadJsonException(UNABLE_READ_EXCEPTION_MESSAGE);
			}
			log.info("In Command Line Runner : END");
		};
	}
}
