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

import com.cg.paymentapp.entity.BeneficiaryDetails;
import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.exception.CustomerNotFoundException;
import com.cg.paymentapp.service.IBeneficiaryService;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:3000")
public class BeneficiaryController {
	
	@Autowired
	IBeneficiaryService beneficiaryService;
	
	
	@PostMapping("/addbeneficiary")
	public ResponseEntity<BeneficiaryDetails> addBeneficiary(@RequestBody BeneficiaryDetails bd)
	{
		return new ResponseEntity<>(beneficiaryService.addBeneficiary(bd),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/beneficiarydelete/{mobNo}")
	public ResponseEntity<BeneficiaryDetails> deleteBeneficiary(@PathVariable("mobNo") String mobNo)
	{
		return new ResponseEntity<>(beneficiaryService.deleteBeneficiary(mobNo),HttpStatus.OK);
	}
	
	@GetMapping("/viewbeneficiary/{mobNo}")
	public ResponseEntity<BeneficiaryDetails> viewBeneficiary(@PathVariable("mobNo") String mobNumber)
	{
		return new ResponseEntity<>(beneficiaryService.viewBeneficiary(mobNumber),HttpStatus.OK);
	}
	
	@GetMapping("/viewallbeneficiary")
	public ResponseEntity<List<BeneficiaryDetails>> viewAllBeneficiary(@RequestBody Customer customer) throws CustomerNotFoundException
	{
		return new ResponseEntity<>(beneficiaryService.viewAllBeneficiary(customer),HttpStatus.OK);
	}
	

}
