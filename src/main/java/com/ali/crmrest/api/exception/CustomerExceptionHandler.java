package com.ali.crmrest.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		
		CustomerErrorResponse customerError = new 
			CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), 
										System.currentTimeMillis());
		
		// first parameter is body and second status code
		return new ResponseEntity<>(customerError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception  exc) {
		
		CustomerErrorResponse customerError = new 
				CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), 
										System.currentTimeMillis());
		
		// first parameter is body and second status code
		return new ResponseEntity<>(customerError, HttpStatus.BAD_REQUEST);
	}
	
}
