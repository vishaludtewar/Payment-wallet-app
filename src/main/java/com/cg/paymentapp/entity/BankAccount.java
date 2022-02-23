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
@Table(name="bankaccount")
public class BankAccount {
	
	@Id
	@Column(name = "accno")
	@NotNull(message="accno is required")
	int accountNo;
	@Pattern(regexp = "^[A-Z]+[0-9]+$")
	@Column(name = "ifsc")
	String ifscCode;
	@Column(name = "bankname")
	@NotNull(message="bank name required")
	String bankName;
	@Column(name = "balance")
	double balance;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "WalletId",referencedColumnName="Walletid")
	private Wallet wallet;
	
	
	
	public BankAccount(int accountNo,String ifscCode,String bankName, double balance) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.balance = balance;
	}
	
	


	public BankAccount( int accountNo,String ifscCode,String bankName, double balance, Wallet wallet) {
		super();
		this.accountNo = accountNo;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.balance = balance;
		this.wallet = wallet;
	}




	public BankAccount() {
		super();
	}


	public int getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}


	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", ifscCode=" + ifscCode + ", bankName=" + bankName
				+ ", balance=" + balance + ", wallet=" + wallet + "]";
	}
	
	

}
