package com.cg.paymentapp.exception;

public class AccountAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountAlreadyExistsException(String msg){
		super(msg);
	}
	
}
