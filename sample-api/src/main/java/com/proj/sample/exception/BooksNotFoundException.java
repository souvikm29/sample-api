package com.proj.sample.exception;

@SuppressWarnings("serial")
public class BooksNotFoundException extends RuntimeException {

	public BooksNotFoundException(String message) {
		super(message);
	}
}
