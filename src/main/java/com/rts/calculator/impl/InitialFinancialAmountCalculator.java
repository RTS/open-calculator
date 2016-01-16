package com.rts.calculator.impl;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.calculator.FinancialEngine;

public class InitialFinancialAmountCalculator extends FinancialEngine {

	private static final InitialFinancialAmountCalculator INITIAL_FINANCIAL_AMOUT_CALCULATOR = new InitialFinancialAmountCalculator();

	public static InitialFinancialAmountCalculator getInstance() {
		return INITIAL_FINANCIAL_AMOUT_CALCULATOR;
	}

	private InitialFinancialAmountCalculator() {
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