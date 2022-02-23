package com.cg.paymentapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.entity.BankAccount;
import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.entity.Wallet;
import com.cg.paymentapp.exception.BankAccountNotFoundException;
import com.cg.paymentapp.exception.CustomerException;
import com.cg.paymentapp.exception.CustomerNotFoundException;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repository.IAccountRepository;
import com.cg.paymentapp.repository.IUserRepository;
import com.cg.paymentapp.repository.IWalletRepository;


@Service
public class WalletServiceImp implements WalletService{
	
	Logger logger = LogManager.getLogger(WalletServiceImp.class);
	@Autowired
	IWalletRepository wrepo;
	
	@Autowired
	IUserRepository userrepo;
	
	@Autowired
	IAccountRepository accrepo;
	
	public WalletServiceImp()
	{
		super();
	}
	

	//Wallet Creation only if user is created but no wallet created
	@Override
	public Customer createAccount(String name, String mobileno, BigDecimal amount){
			
			Customer cust = userrepo.findOne(mobileno);

			if (cust == null) {
				throw new InvalidInputException("No customer found for the mobile no :"+mobileno);		
			} else if (cust.getWallet() == null) {
				Wallet w = new Wallet();
				w.setBalance(amount);
				cust.setWallet(w);
				userrepo.save(cust);
				return cust;
			} else {
				throw new InvalidInputException("Wallet Already Present");
			}

	}
	
	@Override
	public Customer showBalance(String mobileno){
		
		if(userrepo.findOne(mobileno) == null)
		{
			throw new CustomerNotFoundException("Not Exist");
		}
		else {
		Customer cust =userrepo.findOne(mobileno);
		Customer cust1 = new Customer();
		cust1.setName(cust.getName());
		cust1.setWallet(cust.getWallet());
		cust1.setMobileNumber(cust.getMobileNumber());
		logger.info("Founded");
		return cust1;
		}

	}

	@Override
	public void fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount){

		Customer source = userrepo.findOne(sourceMobileNo);
		Customer target = userrepo.findOne(targetMobileNo);
		
		if(source.getWallet().getBalance().doubleValue() < amount.doubleValue())
		{
			throw new CustomerException("Low Balance");
		}
		else 
		{
			BigDecimal sourcemoney = source.getWallet().getBalance().subtract(amount);
			BigDecimal targetmoney = target.getWallet().getBalance().add(amount);
			source.getWallet().setBalance(sourcemoney);
			target.getWallet().setBalance(targetmoney);
			userrepo.save(source);
			userrepo.save(target);
			logger.info("Money Transferred");
		}	
		
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount){
				
		Customer cust =userrepo.findOne(mobileNo);
		
		BankAccount bacc = accrepo.viewAccount(cust.getWallet());
		
		if(bacc == null)
		{
			throw new BankAccountNotFoundException("No Bank Account For This Wallet");
		}
		else
		{
			cust.getWallet().setBalance(cust.getWallet().getBalance().add(amount));
			bacc.setBalance(bacc.getBalance()-amount.doubleValue());
			accrepo.save(bacc);
			userrepo.save(cust);	
			logger.info("Money added to the Wallet from bank Account.");
		}
		return cust;
	}

	@Override
	public List<Customer> getList() {
		return userrepo.findAll();
	}
	
	@Override
	public Customer updateAccount(Customer customer){
		
		Customer cb1 = userrepo.findOne(customer.getMobileNumber());
		
		if(cb1 == null)
		{
			throw new CustomerException("Account Not Found");
		}
		else
		{	
			cb1.setMobileNumber(customer.getMobileNumber());
			cb1.setPassword(customer.getPassword());
			cb1.setName(customer.getName());
			userrepo.save(cb1);
			logger.info("Account Updated Successfully");
			return cb1;
		}
	}

	@Override
	public Customer addMoney(Wallet wallet, double amount) {
		
		
		Wallet wall = wrepo.getById(wallet.getWalletId());
		BigDecimal bal = BigDecimal.valueOf(amount);
		Customer cust = new Customer();
		if(wall == null)
		{
			throw new InvalidInputException("Wallet Not Found");
		}
		else
			wall.setBalance(wall.getBalance().add(bal));
			wrepo.save(wall);
			logger.info("Money Added to wallet");
		return cust;
	}

}
