package com.cg.paymentapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.entity.Transaction;
import com.cg.paymentapp.entity.Wallet;
import com.cg.paymentapp.service.ITransactionServiceImp;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TransactionController {

	@Autowired
	ITransactionServiceImp service;

	@PostMapping("/addtransaction")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction tran){

		return new ResponseEntity<>(service.addTransaction(tran),HttpStatus.OK);
	}

	@GetMapping("/alltransactions/{walletId}")
	public ResponseEntity<List<Transaction>> viewAllTransactions(@PathVariable int walletId) {

		return new ResponseEntity<>(service.viewAllTransaction(walletId),HttpStatus.OK);
	}

	@GetMapping("/transactionByDate/{from}/{to}")
	public ResponseEntity<List<Transaction>> viewTransactionByDate(@PathVariable CharSequence from, @PathVariable CharSequence to){
	LocalDate from1 = LocalDate.parse(from);
	LocalDate to1 = LocalDate.parse(to);
	return new ResponseEntity<>(service.viewTransactionByDate(from1, to1),HttpStatus.OK);
	}

	@GetMapping("/allTransactionsByType/{type}")
	public ResponseEntity<List<Transaction>> viewAllTransactions(@PathVariable("type") String type) {

		return new ResponseEntity<>(service.viewAllTransactions(type),HttpStatus.OK);
	}
}