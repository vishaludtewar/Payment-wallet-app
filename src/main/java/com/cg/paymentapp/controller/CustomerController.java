package com.cg.paymentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.exception.InvalidLogin;
import com.cg.paymentapp.service.UserServiceImp;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
	
	@Autowired
	UserServiceImp user;
	
	
	@GetMapping("/customer/validate")
	public ResponseEntity<Customer> validateLogin(@RequestParam("mno") String mno,@RequestParam("pass") String pass) throws InvalidLogin{
		return new ResponseEntity<>(user.validateLogin(mno, pass),HttpStatus.OK);

	}
	
	@PostMapping("/customer/add")
	public ResponseEntity<Customer> addAccount(@RequestBody Customer customer) {
		Customer cust = user.addCustomer(customer);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}
	
}
