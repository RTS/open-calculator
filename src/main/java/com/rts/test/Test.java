package com.rts.test;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.calculator.FinancialEngine;
import com.rts.extractors.ConsoleExtractor;

public class Test {

	public static void main(String[] args) {

		InFinancialFlowBean inFinancialFlowBean = new InFinancialFlowBean();

		inFinancialFlowBean.setMonthlyInterestRate(1.0);
		inFinancialFlowBean.setFinancialAmount(25000.0);
		inFinancialFlowBean.setMonthlyDuration(36);

		FinancialEngine financialEngine = FinancialEngine.getInstance();
		OutFinancialFlowBean outFinancialFlowBean = financialEngine.compute(inFinancialFlowBean);

		ConsoleExtractor consoleExtractor = ConsoleExtractor.getInstance();
		consoleExtractor.consolePrintHeader();
		consoleExtractor.consolePrintSchedule(outFinancialFlowBean);
	}

}
