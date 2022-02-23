package com.cg.paymentapp.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.exception.AccountAlreadyExistsException;
import com.cg.paymentapp.exception.InvalidLogin;
import com.cg.paymentapp.repository.IUserRepository;

@Service
public class UserServiceImp implements IUserService{
	
	Logger logger = LogManager.getLogger(UserServiceImp.class);
	@Autowired
	IUserRepository urepo;
	
	@Override
	public Customer validateLogin(String mobileNumber, String password) {
		
		Customer cust = urepo.validateLogin(mobileNumber, password);
		if(cust != null) {
			logger.info("Validation Done");
			return cust;
		}
		else
			throw new InvalidLogin("Invalid Credentials");

	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		if(urepo.existsById(customer.getMobileNumber()))
			throw new AccountAlreadyExistsException("Customer with the mobile no "+customer.getMobileNumber()+" already exists try with other mobile no");
		else {
			urepo.save(customer);
			return customer;
			}
	}
	

}
