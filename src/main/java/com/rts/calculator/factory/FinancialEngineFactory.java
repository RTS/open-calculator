package com.rts.calculator.factory;

import com.rts.calculator.FinancialEngine;
import com.rts.calculator.impl.LoanCalculatorV1;
import com.rts.calculator.impl.LoanCalculatorV2;

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
				return LoanCalculatorV1.getInstance();
			case 2:
				return LoanCalculatorV2.getInstance();
			default:
				return null;
		}
	}

}
