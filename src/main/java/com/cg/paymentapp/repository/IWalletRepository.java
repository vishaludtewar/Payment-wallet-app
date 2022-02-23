package com.cg.paymentapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.entity.Customer;
import com.cg.paymentapp.entity.Wallet;

@Repository
public interface IWalletRepository extends JpaRepository<Wallet, Integer>{
	
	
	@Query(value = "select * from customer where mobile =?1",nativeQuery = true)
	public Customer findOne(String mobileNo);
	
}
