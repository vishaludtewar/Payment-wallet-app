package com.cg.paymentapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.cg.paymentapp.entity.Transaction;
import com.cg.paymentapp.entity.Wallet;




public interface ITransactionRepository extends JpaRepository<Transaction, Integer>{

	@Query(value="select * from transaction where wallet_id = ?1 ",nativeQuery = true)
	public List<Transaction> viewAllTransaction(int wallet);
	
	@Query(value="select * from transaction where type = ?1",nativeQuery = true)
	public List<Transaction> viewAllTransactions(String type);
}
