package com.cg.paymentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paymentapp.entity.BillPayment;
import com.cg.paymentapp.service.IBillPaymentServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BillPaymentController {
	
	@Autowired
	IBillPaymentServiceImpl service;
	
	@PostMapping("/addBillPayment")
	public ResponseEntity<BillPayment> addBillPayment(@RequestBody BillPayment billpayment) {
		
		return new ResponseEntity<>(service.addBillPayment(billpayment),HttpStatus.OK) ;
	}
	
	@GetMapping("/viewBillPayment/{billId}")
	public ResponseEntity<BillPayment> viewBillPayment(@PathVariable("billId") int billId){
		
		return new ResponseEntity<>(service.viewBillPayment(billId),HttpStatus.OK);
	}
	
}