package com.group4.glimpse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group4.glimpse.model.User;

/**
 * @author Group 4
 * BadRequestException is the custom exception.
 */
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message = null;

	public BadRequestException() {
		super();
	}

	/**
	 * @param cause
	 */
	public BadRequestException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public BadRequestException(String message) {
		super(message);
		System.out.println(message);
		handleException();
	}

	/**
	 * Handling exceptions and return http status code
	 * @param message
	 * @return
	 */
	public ResponseEntity<String> handleException(){
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);		
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return message;
	}

}
