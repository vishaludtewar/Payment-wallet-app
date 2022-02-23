package com.cg.paymentapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.paymentapp.entity.Transaction;


public interface ITransactionService {
	
	public Transaction addTransaction(Transaction tran);
	public List<Transaction> viewAllTransaction(int walletId);
	public List<Transaction> viewTransactionByDate(LocalDate from,LocalDate to);
	public List<Transaction> viewAllTransactions(String type);
}