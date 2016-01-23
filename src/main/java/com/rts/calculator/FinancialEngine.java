package com.rts.calculator;

import java.util.ArrayList;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;

public abstract class FinancialEngine {

	public static final int	LOAN_V1	= 1;
	public static final int	LOAN_V2	= 2;

	public abstract OutFinancialFlowBean compute(InFinancialFlowBean inFinancialFlowBean);

	/**
	 * @param outFinancialFlowBean
	 * @param termBean
	 */
	protected void addNewTerm(OutFinancialFlowBean outFinancialFlowBean, TermBean termBean) {
		if (outFinancialFlowBean.getTermBeanList() == null) {
			outFinancialFlowBean.setTermBeanList(new ArrayList<TermBean>());
		}
		outFinancialFlowBean.getTermBeanList().add(termBean);
	}

	/**
	 * 
	 * @param paymentNumber
	 * @param financialAmount
	 * @param paymentAmount
	 * @param interestPaid
	 * @param principalPaid
	 * @param remainingBalance
	 * @return
	 */
	protected TermBean initTerm(int paymentNumber, double financialAmount, double paymentAmount, double interestPaid,
			double principalPaid, double remainingBalance) {
		TermBean termBean = new TermBean();

		termBean.setPaymentNumber(paymentNumber);
		termBean.setFinancialAmount(financialAmount);
		termBean.setPaymentAmount(paymentAmount);
		termBean.setInterestPaid(interestPaid);
		termBean.setPrincipalPaid(principalPaid);
		termBean.setRemainingBalance(remainingBalance);

		return termBean;
	}

	protected int getMonthlyDuration(InFinancialFlowBean inFinancialFlowBean) {
		int monthlyDuration = 0;
		if (inFinancialFlowBean.getYearlyDuration() != null) {
			monthlyDuration = inFinancialFlowBean.getYearlyDuration() * 12;
		} else if (inFinancialFlowBean.getMonthlyDuration() != null) {
			monthlyDuration = inFinancialFlowBean.getMonthlyDuration();
		}
		return monthlyDuration;
	}

	protected double getMonthlyInterestRate(InFinancialFlowBean inFinancialFlowBean) {
		double monthlyInterestRate = .0;
		if (inFinancialFlowBean.getYearlyInterestRate() != null) {
			monthlyInterestRate = (inFinancialFlowBean.getYearlyInterestRate() / 12) / 100;
		} else if (inFinancialFlowBean.getMonthlyInterestRate() != null) {
			monthlyInterestRate = inFinancialFlowBean.getMonthlyInterestRate() / 100;
		}
		return monthlyInterestRate;
	}

	protected double getFinancialAmount(InFinancialFlowBean inFinancialFlowBean) {
		double financialAmount = .0;
		if (inFinancialFlowBean.getFinancialAmount() != null) {
			financialAmount = inFinancialFlowBean.getFinancialAmount();
		}
		return financialAmount;
	}
}
