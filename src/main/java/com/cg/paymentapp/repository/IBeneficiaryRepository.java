package com.cg.paymentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.entity.BeneficiaryDetails;
import com.cg.paymentapp.entity.Customer;

@Repository
public interface IBeneficiaryRepository extends JpaRepository<BeneficiaryDetails, String> {
	
	
	
	@Query(value="select * from beneficiary where mobileno = ?1",nativeQuery = true)
	public BeneficiaryDetails viewBeneficiary(String mobNo);
	@Query(value="select * from beneficiary where cast(wallet_id as varchar) = '?1'",nativeQuery = true)
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer);
}
