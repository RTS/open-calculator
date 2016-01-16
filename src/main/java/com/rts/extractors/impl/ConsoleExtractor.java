package com.rts.extractors.impl;

import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;
import com.rts.extractors.Extractor;
import com.rts.utils.AmountFormatter;

public class ConsoleExtractor implements Extractor {

	private static final ConsoleExtractor	CONSOLE_EXTRACTOR		= new ConsoleExtractor();

	private int								defaultDecimalPrecision	= 2;
	private String							leftAlignFormat			= "| %-2.0f | %-18.2f | %-15.2f | %-16.2f | %-14.2f | %-11.2f |%n";

	public static ConsoleExtractor getInstance() {
		return CONSOLE_EXTRACTOR;
	}

	private ConsoleExtractor() {
	}

	public void printSchedule(OutFinancialFlowBean outFinancialFlowBean) {

		System.out.format("+----+--------------------+-----------------+------------------+----------------+-------------+%n");
		System.out.format("| N° | Financial amount   | Monthly payment | Monthly interest | Principal paid | New balance |%n");
		System.out.format("+----+--------------------+-----------------+------------------+----------------+-------------+%n");

		if (outFinancialFlowBean != null && !outFinancialFlowBean.getTermBeanList().isEmpty()) {
			for (TermBean termBean : outFinancialFlowBean.getTermBeanList()) {
				System.out.format(leftAlignFormat, AmountFormatter.round(termBean.getPaymentNumber(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getFinancialAmount(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getPaymentAmount(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getInterestPaid(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getPrincipalPaid(), defaultDecimalPrecision),
						AmountFormatter.round(termBean.getRemainingBalance(), defaultDecimalPrecision));
			}
		}
		System.out.format("+----+--------------------+-----------------+------------------+----------------+-------------+%n");
	}

}
