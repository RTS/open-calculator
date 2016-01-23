package com.rts.calculator.impl;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;
import com.rts.calculator.FinancialEngine;

public class LoanCalculatorV1 extends FinancialEngine {

	private static final LoanCalculatorV1 LOAN_CALCULATOR_V1 = new LoanCalculatorV1();

	public static LoanCalculatorV1 getInstance() {
		return LOAN_CALCULATOR_V1;
	}

	private LoanCalculatorV1() {
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
