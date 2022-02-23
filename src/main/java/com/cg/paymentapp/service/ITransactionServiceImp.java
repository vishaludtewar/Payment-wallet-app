package com.cg.paymentapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paymentapp.entity.Transaction;
import com.cg.paymentapp.exception.AccountAlreadyExistsException;
import com.cg.paymentapp.exception.InvalidInputException;
import com.cg.paymentapp.repository.ITransactionRepository;
import com.cg.paymentapp.repository.IWalletRepository;


@Service
public class ITransactionServiceImp implements ITransactionService{

	Logger logger = LogManager.getLogger(ITransactionServiceImp.class);

	@Autowired
	ITransactionRepository transactionRepo;
	
	@Autowired
    IWalletRepository walletRepo;


	@Override
	public Transaction addTransaction(Transaction tran) {

		if(transactionRepo.existsById(tran.getTransactionId()))
			throw new AccountAlreadyExistsException("Transaction id "+tran.getTransactionId()+" already exists Try with some other Id");
		else if(!walletRepo.existsById(tran.getWallet().getWalletId()))
			throw new InvalidInputException("Given Wallet id not present");
		else {
			transactionRepo.save(tran);
			logger.info("Transaction added successfully.");
			return tran;
		}
	}

	@Override
	public List<Transaction> viewTransactionByDate(LocalDate from, LocalDate to){
	List<Transaction> list=new ArrayList<>();
	for (Transaction transaction : transactionRepo.findAll()) {
	if(transaction.getTransactionDate().isAfter(from) && transaction.getTransactionDate().isBefore(to)) {
	list.add(transaction);
	}
	}
	return list;
	}



	@Override
	public List<Transaction> viewAllTransactions(String type) {

		logger.info("Details of All Transaction by Transaction Type.");
		return transactionRepo.viewAllTransactions(type);
	}
	
	@Override
	public List<Transaction> viewAllTransaction(int wallet) {

	logger.info("Details of All Transaction by Transaction Wallet.");
	return transactionRepo.viewAllTransaction(wallet);
	}

}