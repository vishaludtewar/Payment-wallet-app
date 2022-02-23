package com.cg.paymentapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Beneficiary")
public class BeneficiaryDetails {
	
	@NotNull(message="beneficiary name required")
	String name;
	@Id
	@Pattern(regexp = "^[0-9]{10}$",message = "Must be 10 digits")
	@Column(name="mobileno")
	String mobileNumber;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "WalletId", referencedColumnName = "Walletid")
	private Wallet wallet;

	
	
	public BeneficiaryDetails() {
		super();
	}



	public BeneficiaryDetails(String name, String mobileNumber) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
	}
	
	
	


	public BeneficiaryDetails(String name, String mobileNumber, Wallet wallet) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
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

	public Wallet getWallet() {
		return wallet;
	}



	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



	@Override
	public String toString() {
		return "BeneficiaryDetails [name=" + name + ", mobileNumber=" + mobileNumber + ", wallet=" + wallet + "]";
	}
	
	
	
}
