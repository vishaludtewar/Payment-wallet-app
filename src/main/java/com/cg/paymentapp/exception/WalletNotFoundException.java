package com.cg.paymentapp.exception;

public class WalletNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WalletNotFoundException()
	{
		super();
	}
	
	public WalletNotFoundException(String msg)
	{
		super(msg);
	}

}
