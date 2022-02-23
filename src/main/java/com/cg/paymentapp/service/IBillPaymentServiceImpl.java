package com.cg.paymentapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.entity.BillPayment;
import com.cg.paymentapp.exception.BillPaymentDetailsNotFoundException;
import com.cg.paymentapp.exception.WalletNotFoundException;
import com.cg.paymentapp.repository.IBillPaymentRepository;
import com.cg.paymentapp.repository.IWalletRepository;

@Service
public class IBillPaymentServiceImpl implements IBillPaymentService {
	
	@Autowired(required=true)
    IBillPaymentRepository billPaymentRepo;
	@Autowired
    IWalletRepository wrepo;
	
	
	@Override
	public BillPayment addBillPayment(BillPayment payment) {
		
		if(!wrepo.existsById(payment.getWallet().getWalletId())) {
			throw new WalletNotFoundException("No Wallet Found");
		}
		else
			return billPaymentRepo.save(payment); 
	}

	@Override
	public BillPayment viewBillPayment(int billId) {
		
		if(!billPaymentRepo.existsById(billId)) {
			throw new BillPaymentDetailsNotFoundException("Details not found");
		}
		else {
			return billPaymentRepo.viewBillPayment(billId);    
		
	}
	}
}