package com.rts.calculator.impl;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;
import com.rts.calculator.FinancialEngine;
import com.rts.utils.AmountFormatter;

public class LoanCalculatorV2 extends FinancialEngine {

	private static final LoanCalculatorV2 LOAN_CALCULATOR_V2 = new LoanCalculatorV2();

	public static LoanCalculatorV2 getInstance() {
		return LOAN_CALCULATOR_V2;
	}

	private LoanCalculatorV2() {
	}

	public OutFinancialFlowBean compute(InFinancialFlowBean inFinancialFlowBean) {

		// Init output
		OutFinancialFlowBean outFinancialFlowBean = new OutFinancialFlowBean();
		outFinancialFlowBean.setInFinancialFlowBean(inFinancialFlowBean);

		double financialAmount = this.getFinancialAmount(inFinancialFlowBean);
		double monthlyInterestRate = this.getMonthlyInterestRate(inFinancialFlowBean);
		int monthlyDuration = this.getMonthlyDuration(inFinancialFlowBean);

		if (financialAmount <= 0) {
			// Balance must be greater than zero.
		}
		if (monthlyDuration <= 0) {
			// Term must be greater than zero.
		}
		if (monthlyInterestRate < 0) {
			// Rate must at least zero.
		}

		double paymentAmount = getPeriodicPayment(monthlyInterestRate, monthlyDuration, financialAmount);

		double interestPaid = 0;
		double principalPaid = 0;
		double remainingBalance = financialAmount;
		double a = paymentAmount;

		for (int paymentNumber = 0; paymentNumber < monthlyDuration; paymentNumber++) {

			interestPaid = AmountFormatter.round(monthlyInterestRate * remainingBalance, 2);
			principalPaid = paymentAmount - interestPaid;
			remainingBalance -= principalPaid;

			if (remainingBalance < 0) {
				a += remainingBalance;
				remainingBalance = 0;
				principalPaid = a - interestPaid;
			} else {
				a = paymentAmount;
			}

			if (monthlyDuration - 1 == paymentNumber) {
				if (remainingBalance > 0.005 || remainingBalance < 0.005) {
					a += remainingBalance;
					remainingBalance = 0;
					principalPaid = a - interestPaid;
				} else {
					remainingBalance = 0;
				}
			}

			TermBean termBean = this.initTerm(paymentNumber, remainingBalance + principalPaid, interestPaid + principalPaid,
					interestPaid, principalPaid, remainingBalance);

			this.addNewTerm(outFinancialFlowBean, termBean);

		}

		return outFinancialFlowBean;
	}

}