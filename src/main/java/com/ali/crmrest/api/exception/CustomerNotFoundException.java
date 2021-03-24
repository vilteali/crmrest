package com.ali.crmrest.api.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7956022253979433017L;

	public CustomerNotFoundException() {
	}

	public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
