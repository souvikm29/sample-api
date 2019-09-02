package com.proj.sample.exception;

import java.io.IOException;

@SuppressWarnings("serial")
public class UnableToReadJsonException extends IOException {

	public UnableToReadJsonException(String message) {
		super(message);
	}
}
