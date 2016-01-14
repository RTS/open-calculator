package com.rts.extractors;

import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;
import com.rts.utils.AmountFormatter;

public class ConsoleExtractor {

	private static final ConsoleExtractor	CONSOLE_EXTRACTOR		= new ConsoleExtractor();

	private int								defaultDecimalPrecision	= 2;
	private String							leftAlignFormat			= "| %-2.0f | %-18.2f | %-15.2f | %-16.2f | %-14.2f | %-11.2f |%n";

	public static ConsoleExtractor getInstance() {
		return CONSOLE_EXTRACTOR;
	}

	private ConsoleExtractor() {
	}

	public void consolePrintHeader() {

		System.out.format("+----+--------------------+-----------------+------------------+----------------+-------------+%n");
		System.out.format("| N° | Financial amount   | Monthly payment | Monthly interest | Principal paid | New balance |%n");
		System.out.format("+----+--------------------+-----------------+------------------+----------------+-------------+%n");
	}

	public void consolePrintSchedule(OutFinancialFlowBean outFinancialFlowBean) {

		if (outFinancialFlowBean != null && !outFinancialFlowBean.getTermBeanList().isEmpty()) {
			for (TermBean termBean : outFinancialFlowBean.getTermBeanList()) {
				System.out.format(leftAlignFormat, AmountFormatter.round(termBean.getTermNumber(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getFinancialAmount(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getMonthlyPayment(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getMonthlyInterest(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getPrincipalPaid(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getNewbalance(), defaultDecimalPrecision));
			}
		}
		System.out.format("+----+--------------------+-----------------+------------------+----------------+-------------+%n");
	}

}
