package com.cg.paymentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.entity.BankAccount;
import com.cg.paymentapp.entity.Wallet;
import com.cg.paymentapp.exception.InvalidUserInputException;
import com.cg.paymentapp.repository.IAccountRepository;
import com.cg.paymentapp.repository.IWalletRepository;

@Service
public class AccountServiceImp implements IAccountService{

	@Autowired
	IAccountRepository accountRepo;
	
	@Autowired
    IWalletRepository walletRepo;
	
	@Override
	public Wallet addAccount(BankAccount bacc) {
		Wallet w = bacc.getWallet();
		
		if (walletRepo.existsById(w.getWalletId()) && !accountRepo.existsById(bacc.getAccountNo())) {
			accountRepo.save(bacc);
			return w;
		}
		else
			throw new InvalidUserInputException("Wallet doesn't exist or Account already exist");
	}

	@Override
	public Wallet removeAccount(BankAccount bacc) {
		
		
		BankAccount bacc1 = accountRepo.getById(bacc.getAccountNo());
		Wallet w = bacc1.getWallet();
		if (accountRepo.existsById(bacc1.getAccountNo()))
		{
			accountRepo.delete(bacc);
			return w;
			
		}
		else
			throw new InvalidUserInputException("Account not exist doesn't exists");
	}

	@Override
	public BankAccount viewAccount(Wallet wallet) {
		
		Wallet wall = walletRepo.getById(wallet.getWalletId());
		if (wall == null)
			throw new InvalidUserInputException("Wallet " + wallet.getWalletId() + "not present");
		else {
			return accountRepo.viewAccount(wallet);
		
		}
		
	}

	@Override
	public List<BankAccount> viewAllAccounts() {		
		return accountRepo.findAll();
	}
	

}
