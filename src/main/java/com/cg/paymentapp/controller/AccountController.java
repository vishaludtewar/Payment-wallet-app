package com.cg.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.entity.BankAccount;
import com.cg.paymentapp.entity.Wallet;
import com.cg.paymentapp.service.AccountServiceImp;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

	@Autowired(required = true)
	AccountServiceImp accountService;
	
	@PostMapping("/addAccount")
	public ResponseEntity<Wallet> addAccount(@RequestBody BankAccount bacc) {
		return new ResponseEntity<>(accountService.addAccount(bacc),HttpStatus.OK);
	}
	
	@DeleteMapping("/removeAccount")
	public ResponseEntity<Wallet> removeAccount(@RequestBody BankAccount bacc) {
		return new ResponseEntity<>(accountService.removeAccount(bacc),HttpStatus.GONE);
	}
	
	@GetMapping("/viewAccount")
	public ResponseEntity<BankAccount> viewAccount(@RequestBody Wallet wallet) {
		return new ResponseEntity<>(accountService.viewAccount(wallet),HttpStatus.OK);
	}
	
	@GetMapping("/viewAllAccount")
	public ResponseEntity<List<BankAccount>> viewAllAccounts(){
		return new ResponseEntity<>(accountService.viewAllAccounts(),HttpStatus.OK);
	}
}
