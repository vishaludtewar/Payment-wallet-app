package com.cg.paymentapp.service;


import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.exception.InvalidLogin;

public interface IUserService {
	
	public Customer validateLogin(String mobileNumber,String password) throws InvalidLogin;
	public Customer addCustomer(Customer customer);

}
