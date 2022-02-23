package com.cg.paymentapp.exception;

public class BankAccountNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BankAccountNotFoundException(String msg)
	{
		super(msg);
	}
	

}
