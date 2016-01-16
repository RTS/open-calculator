package com.rts.beans;

import java.util.Date;

public class TermBean {

	private int		paymentNumber;
	private Date	paymentDate;
	private Double	paymentAmount;
	private Double	interestPaid;
	private Double	principalPaid;
	private Double	financialAmount;
	private Double	remainingBalance;

	/**
	 * @return the paymentNumber
	 */
	public int getPaymentNumber() {
		return paymentNumber;
	}

	/**
	 * @param paymentNumber
	 *            the paymentNumber to set
	 */
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate
	 *            the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the paymentAmount
	 */
	public Double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount
	 *            the paymentAmount to set
	 */
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the interestPaid
	 */
	public Double getInterestPaid() {
		return interestPaid;
	}

	/**
	 * @param interestPaid
	 *            the interestPaid to set
	 */
	public void setInterestPaid(Double interestPaid) {
		this.interestPaid = interestPaid;
	}

	/**
	 * @return the principalPaid
	 */
	public Double getPrincipalPaid() {
		return principalPaid;
	}

	/**
	 * @param principalPaid
	 *            the principalPaid to set
	 */
	public void setPrincipalPaid(Double principalPaid) {
		this.principalPaid = principalPaid;
	}

	/**
	 * @return the financialAmount
	 */
	public Double getFinancialAmount() {
		return financialAmount;
	}

	/**
	 * @param financialAmount
	 *            the financialAmount to set
	 */
	public void setFinancialAmount(Double financialAmount) {
		this.financialAmount = financialAmount;
	}

	/**
	 * @return the remainingBalance
	 */
	public Double getRemainingBalance() {
		return remainingBalance;
	}

	/**
	 * @param remainingBalance
	 *            the remainingBalance to set
	 */
	public void setRemainingBalance(Double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

}
