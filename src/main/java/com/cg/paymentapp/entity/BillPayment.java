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
@Entity
@Table(name="billpayment")
public class BillPayment {
    
	@Id
	@Column(name="billid")
	private int billId;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "WalletId", referencedColumnName = "Walletid")
	private Wallet wallet;
	private BillType billtype;
	@NotNull(message = "Amount should not be null")
	private double amount;
	@Column(name="paymentdate")
	private LocalDate paymentDate;

	public BillPayment() {

	}

	public BillPayment(int billId, Wallet wallet, BillType billtype, double amount, LocalDate paymentDate) {
		super();
		this.billId = billId;
		this.wallet = wallet;
		this.billtype = billtype;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public BillType getBilltype() {
		return billtype;
	}

	public void setBilltype(BillType billtype) {
		this.billtype = billtype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "BillPayment [billId=" + billId + ", wallet=" + wallet + ", billtype=" + billtype + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}

}