package com.cg.paymentapp.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;


@Entity
@Table(name="Wallet")
public class Wallet {
	
	@Id
	@GeneratedValue
	@Column(name="Walletid")
	int walletId;
	@Column(name="balance")
	@Min(value=1000,message = "Minimum balance should be 1000")
	BigDecimal balance;
	
	public Wallet() {
		super();
	}
	
	public Wallet(int walletId, BigDecimal balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}
	
	
	
	public Wallet(int walletId) {
		super();
		this.walletId = walletId;
	}
	

	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", balance=" + balance + "]";
	}
	
}
