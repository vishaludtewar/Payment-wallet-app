package com.cg.paymentapp.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.entity.Wallet;
import com.cg.paymentapp.service.WalletService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WalletController {

	@Autowired
	WalletService wallet;
	
	
	@PostMapping("/wallet/create/{name}/{mobileno}/{amount}")
	public ResponseEntity<Customer> createAccount(@PathVariable("name") String name, @PathVariable("mobileno") String mobileno,
			@PathVariable("amount") BigDecimal amount)
	{
		Customer cust = wallet.createAccount(name, mobileno, amount);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}
	
	
	@GetMapping("/wallet/balance/{mobileno}")	
	public ResponseEntity<Customer> showBalance(@PathVariable("mobileno") String mobileno)
	{
		return new ResponseEntity<>(wallet.showBalance(mobileno),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/wallet/amounttransfer/{sourceMobileNo}/{targetMobileNo}/{amount}")
	public void fundTransfer(@PathVariable("sourceMobileNo") String sourceMobileNo,@PathVariable("targetMobileNo") String targetMobileNo,@PathVariable("amount")BigDecimal amount)
	{
		wallet.fundTransfer(sourceMobileNo, targetMobileNo, amount);
	}
	
	@PutMapping("/wallet/deposit/{mobileNo}/{amount}")
	public ResponseEntity<Customer> depositAmount(@PathVariable("mobileNo") String mobileNo,@PathVariable("amount") BigDecimal amount)
	{
		Customer cust = wallet.depositAmount(mobileNo, amount);
		return new ResponseEntity<>(cust,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/wallet/addmoney/{amount}")
	public ResponseEntity<Customer> addMoney(@RequestBody Wallet wallet1,@PathVariable("amount") double amount)
	{
		Customer cust = wallet.addMoney(wallet1, amount);
		return new ResponseEntity<>(cust,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/wallet/all")
	public ResponseEntity<List<Customer>> getList()
	{		
		return new ResponseEntity<>(wallet.getList(),HttpStatus.OK);
	}
	
	@PutMapping("/wallet/update")
	public ResponseEntity<Customer> updateAccount(@RequestBody Customer customer)
	{
		return new ResponseEntity<>(wallet.updateAccount(customer),HttpStatus.ACCEPTED);
	}
	
}
