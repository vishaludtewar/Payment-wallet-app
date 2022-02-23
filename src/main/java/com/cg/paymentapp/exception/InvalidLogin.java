package com.cg.paymentapp.exception;

public class InvalidLogin extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidLogin(String msg) {
		super(msg);
	}
	

}
