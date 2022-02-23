package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.entity.BeneficiaryDetails;
import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.exception.CustomerNotFoundException;

public interface IBeneficiaryService {
	

	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd);
	public BeneficiaryDetails deleteBeneficiary(String mobileNumber);
	public BeneficiaryDetails viewBeneficiary(String mobNo);
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) throws CustomerNotFoundException;

}
