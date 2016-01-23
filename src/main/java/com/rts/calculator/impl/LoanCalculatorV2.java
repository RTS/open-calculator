package com.rts.calculator.impl;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.calculator.FinancialEngine;

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

		double loyer = 25000.0 - 0 + 0 * 0.1;
		System.out.println(loyer);

		return outFinancialFlowBean;
	}

}