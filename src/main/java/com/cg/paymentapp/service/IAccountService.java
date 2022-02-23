package com.cg.paymentapp.service;

import java.util.List;

import com.cg.paymentapp.entity.BankAccount;
import com.cg.paymentapp.entity.Wallet;

public interface IAccountService {
	
	
	public Wallet addAccount(BankAccount bacc);
	public Wallet removeAccount(BankAccount bacc);
	public BankAccount viewAccount(Wallet wallet);
	public List<BankAccount> viewAllAccounts();

}
