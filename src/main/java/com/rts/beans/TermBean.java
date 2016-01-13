package com.rts.beans;

public class TermBean {

	private Integer	termNumber;
	private Double	financialAmount;
	private Double	monthlyPayment;
	private Double	monthlyInterest;
	private Double	principalPaid;
	private Double	newbalance;

	/**
	 * @return the termNumber
	 */
	public Integer getTermNumber() {
		return termNumber;
	}

	/**
	 * @param termNumber
	 *            the termNumber to set
	 */
	public void setTermNumber(Integer termNumber) {
		this.termNumber = termNumber;
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
	 * @return the monthlyPayment
	 */
	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	/**
	 * @param monthlyPayment
	 *            the monthlyPayment to set
	 */
	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	/**
	 * @return the monthlyInterest
	 */
	public Double getMonthlyInterest() {
		return monthlyInterest;
	}

	/**
	 * @param monthlyInterest
	 *            the monthlyInterest to set
	 */
	public void setMonthlyInterest(Double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
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
	 * @return the newbalance
	 */
	public Double getNewbalance() {
		return newbalance;
	}

	/**
	 * @param newbalance
	 *            the newbalance to set
	 */
	public void setNewbalance(Double newbalance) {
		this.newbalance = newbalance;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TermBean [termNumber=" + termNumber + ", financialAmount=" + financialAmount + ", monthlyPayment="
				+ monthlyPayment + ", monthlyInterest=" + monthlyInterest + ", principalPaid=" + principalPaid
				+ ", newbalance=" + newbalance + "]";
	}

}
