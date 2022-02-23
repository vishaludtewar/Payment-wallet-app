package com.cg.paymentapp.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name = "transid")
	@NotNull(message="Transaction id required")
	int transactionId;
	@NotNull(message="transaction type required")
	@Column(name="type")
	String transactionType;
	@NotNull(message="transaction date required")
	@Column(name="date")
	@CreationTimestamp
	LocalDate transactionDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "WalletId", referencedColumnName = "Walletid")
	Wallet wallet;
	double amount;
	@Size(min=5,max=100,message="description length must be of length 5 to 100")
	String description;

	public Transaction() {

	}

	public Transaction(int transactionId, String transactionType, LocalDate transactionDate, Wallet wallet, double amount, String description) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.wallet = wallet;
		this.amount = amount;
		this.description = description;
	}


	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionDate=" + transactionDate + ", wallet=" + wallet + ", amount=" + amount
				+ ", description=" + description + "]";
	}

}