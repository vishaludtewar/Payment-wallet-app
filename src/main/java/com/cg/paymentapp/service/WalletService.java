package com.cg.paymentapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.entity.Wallet;

public interface WalletService {
	
	public Customer createAccount(String name,String mobileno,BigDecimal amount);
	public Customer showBalance(String mobileno);
	public void fundTransfer(String sourceMobileNo,String targetMobileNo,BigDecimal amount);
	public Customer depositAmount(String mobileNo,BigDecimal amount);
	public List<Customer> getList();
	public Customer updateAccount(Customer customer);
	public Customer addMoney(Wallet wallet,double amount);
}
