package com.cg.paymentapp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.paymentapp.entity.Customer;

@Repository
public interface IUserRepository extends JpaRepository<Customer, String>{
	
	@Query(value="SELECT * from customer c where c.mobile = ?1 AND password=?2", nativeQuery = true)
	public Customer validateLogin(String mobileNumber,String password);
	
	@Query(value = "select * from customer where mobile =?1",nativeQuery = true)
	public Customer findOne(String mobileNo);
}
 