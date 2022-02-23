package com.cg.paymentapp.exception;

public class InvalidUserInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserInputException(String msg) {
		super(msg);
	}
	
}
