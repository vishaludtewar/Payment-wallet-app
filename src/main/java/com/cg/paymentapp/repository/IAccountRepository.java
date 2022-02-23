package com.cg.paymentapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.paymentapp.entity.BankAccount;
import com.cg.paymentapp.entity.Wallet;


public interface IAccountRepository extends JpaRepository<BankAccount, Integer>{
	

	
	@Query(value="delete from bankaccount where acc_no=?1",nativeQuery = true)
	public Wallet removeAccount(int bacc);
	
	@Query(value="select * from bankaccount where wallet_id=?1",nativeQuery = true)
	public  BankAccount viewAccount(Wallet Wallet);
	

}
