package com.cg.paymentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.entity.BillPayment;

@Repository
public interface IBillPaymentRepository extends JpaRepository<BillPayment, Integer> {
	
	
	
	
	@Query(value =("select * from billpayment where billid=?1"),nativeQuery = true)
	public BillPayment viewBillPayment(int billId);
	

}
