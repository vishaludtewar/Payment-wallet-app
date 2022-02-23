package com.cg.paymentapp.exception;

public class BillPaymentDetailsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BillPaymentDetailsNotFoundException()
	{
		super();
	}
	
	public BillPaymentDetailsNotFoundException(String msg)
	{
		super(msg);
	}

}
