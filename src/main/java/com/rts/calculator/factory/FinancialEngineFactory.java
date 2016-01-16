package com.rts.calculator.factory;

import com.rts.calculator.FinancialEngine;
import com.rts.calculator.impl.InitialFinancialAmountCalculator;
import com.rts.calculator.impl.LoanCalculator;

public class FinancialEngineFactory {

	private static final FinancialEngineFactory FINANCIAL_ENGINE_FACTORY = new FinancialEngineFactory();

	public static FinancialEngineFactory getInstance() {
		return FINANCIAL_ENGINE_FACTORY;
	}

	private FinancialEngineFactory() {
	}

	public FinancialEngine getFinancialEngine(int calculationMethod) {

		switch (calculationMethod) {
			case 1:
				return LoanCalculator.getInstance();
			case 2:
				return InitialFinancialAmountCalculator.getInstance();
			default:
				return null;
		}
	}

}
