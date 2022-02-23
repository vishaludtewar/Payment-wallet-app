package com.cg.paymentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.entity.BeneficiaryDetails;
import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.exception.CustomerNotFoundException;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.exception.InvalidUserInputException;
import com.cg.paymentapp.repository.IBeneficiaryRepository;
import com.cg.paymentapp.repository.IUserRepository;
import com.cg.paymentapp.repository.IWalletRepository;

@Service
public class BeneficiaryServiceImp implements IBeneficiaryService{
	@Autowired
	IBeneficiaryRepository beneficiaryRepository; 
	
	@Autowired
	IWalletRepository walletRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd) {
		
		if (beneficiaryRepository.existsById(bd.getMobileNumber()))
			throw new InvalidInputException("User with this " + bd.getMobileNumber() + " Mobile number Already present");
		else 
			return beneficiaryRepository.save(bd);
		
	}

	@Override
	public BeneficiaryDetails deleteBeneficiary(String mobileNumber) {
		
		if(!beneficiaryRepository.existsById(mobileNumber))
		 {
			throw new InvalidUserInputException("No User Found");
		 }
		else
			beneficiaryRepository.deleteById(mobileNumber);		
		return null;
	}

	@Override
	public BeneficiaryDetails viewBeneficiary(String mobNo) {

		return beneficiaryRepository.viewBeneficiary(mobNo);
	}

	@Override
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) throws CustomerNotFoundException {
		
		if (!userRepository.existsById(customer.getMobileNumber()))
			throw new CustomerNotFoundException("Customer with " + customer.getMobileNumber() + " Mobile number not found.");
		else {
			return beneficiaryRepository.viewAllBeneficiary(customer);
		}
		 
		
	}

}
