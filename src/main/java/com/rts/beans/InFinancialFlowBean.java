package com.rts.beans;

public class InFinancialFlowBean {

	private Double	financialAmount;

	private Double	yearlyInterestRate;
	private Double	monthlyInterestRate;

	private Integer	yearlyDuration;
	private Integer	monthlyDuration;

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
	 * @return the yearlyInterestRate
	 */
	public Double getYearlyInterestRate() {
		return yearlyInterestRate;
	}

	/**
	 * @param yearlyInterestRate
	 *            the yearlyInterestRate to set
	 */
	public void setYearlyInterestRate(Double yearlyInterestRate) {
		this.yearlyInterestRate = yearlyInterestRate;
	}

	/**
	 * @return the monthlyInterestRate
	 */
	public Double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	/**
	 * @param monthlyInterestRate
	 *            the monthlyInterestRate to set
	 */
	public void setMonthlyInterestRate(Double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	/**
	 * @return the yearlyDuration
	 */
	public Integer getYearlyDuration() {
		return yearlyDuration;
	}

	/**
	 * @param yearlyDuration
	 *            the yearlyDuration to set
	 */
	public void setYearlyDuration(Integer yearlyDuration) {
		this.yearlyDuration = yearlyDuration;
	}

	/**
	 * @return the monthlyDuration
	 */
	public Integer getMonthlyDuration() {
		return monthlyDuration;
	}

	/**
	 * @param monthlyDuration
	 *            the monthlyDuration to set
	 */
	public void setMonthlyDuration(Integer monthlyDuration) {
		this.monthlyDuration = monthlyDuration;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InFinancialFlowBean [financialAmount=" + financialAmount + ", yearlyInterestRate=" + yearlyInterestRate
				+ ", monthlyInterestRate=" + monthlyInterestRate + ", yearlyDuration=" + yearlyDuration + "]";
	}

}