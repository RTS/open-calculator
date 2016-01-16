package com.rts.calculator.impl;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;
import com.rts.calculator.FinancialEngine;

public class LoanCalculator extends FinancialEngine {

	private static final LoanCalculator LOAN_CALCULATOR = new LoanCalculator();

	public static LoanCalculator getInstance() {
		return LOAN_CALCULATOR;
	}

	private LoanCalculator() {
	}

	public OutFinancialFlowBean compute(InFinancialFlowBean inFinancialFlowBean) {

		// Init output
		OutFinancialFlowBean outFinancialFlowBean = new OutFinancialFlowBean();
		outFinancialFlowBean.setInFinancialFlowBean(inFinancialFlowBean);

		double financialAmount = this.getFinancialAmount(inFinancialFlowBean);
		double monthlyInterestRate = this.getMonthlyInterestRate(inFinancialFlowBean);
		int monthlyDuration = this.getMonthlyDuration(inFinancialFlowBean);

		double paymentAmount = .0, interestPaid = .0, principalPaid = .0;

		// calculation function
		paymentAmount = (financialAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -monthlyDuration));

		int paymentNumber;
		for (paymentNumber = 1; paymentNumber < monthlyDuration; paymentNumber++) {

			interestPaid = financialAmount * monthlyInterestRate;
			principalPaid = paymentAmount - interestPaid;

			TermBean termBean = this.initTerm(paymentNumber, financialAmount, paymentAmount, interestPaid, principalPaid,
					financialAmount - principalPaid);

			this.addNewTerm(outFinancialFlowBean, termBean);

			// remainingBalance
			financialAmount -= principalPaid;
		}

		// last month
		TermBean termBean = this.initTerm(paymentNumber, financialAmount, financialAmount + interestPaid,
				financialAmount * monthlyInterestRate, financialAmount, 0);

		this.addNewTerm(outFinancialFlowBean, termBean);

		return outFinancialFlowBean;
	}

}
