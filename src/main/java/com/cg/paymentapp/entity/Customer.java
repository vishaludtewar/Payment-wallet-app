package com.cg.paymentapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Column(name="Name")
	String name;
	
	@Id
	@NotNull
	@Column(name="mobile")
	@Pattern(regexp = "^[0-9]{10}$",message = "Must be 10 digits")
	String mobileNumber;
	
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")
	String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="WalletId",referencedColumnName = "Walletid")
	Wallet wallet;
	
	public Customer(String name, String mobileNumber, String password, Wallet wallet) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.wallet = wallet;
	}

	

	public Customer(String name, String mobileNumber, String password) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}



	public Customer() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNumber=" + mobileNumber +  ", wallet="
				+ wallet + "]";
	}
	
	

}
