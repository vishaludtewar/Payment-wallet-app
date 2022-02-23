package com.cg.paymentapp.exception;

public class CustomerAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1612721573413290259L;

	public CustomerAlreadyExistsException() {
		
		
	}

	public CustomerAlreadyExistsException(String msg) {
		super(msg);
		
	}
	
}
