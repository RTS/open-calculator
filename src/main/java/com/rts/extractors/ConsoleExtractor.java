package com.rts.extractors;

import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;

public class ConsoleExtractor {

	private static final ConsoleExtractor CONSOLE_EXTRACTOR = new ConsoleExtractor();

	public static ConsoleExtractor getInstance() {
		return CONSOLE_EXTRACTOR;
	}

	private ConsoleExtractor() {
	}

	private int decimalPrecision = 0;

	public void consolePrintHeader() {
		int i;
		System.out.println("\nAmortization Schedule");
		for (i = 0; i < 62; i++)
			System.out.print("-");
		System.out.format("\n%-8s%-12s%-10s%-10s%-10s%-12s", " ", "Old", "Monthly", "Interest", "Principle", "New",
				"Balance");
		System.out.format("\n%-8s%-12s%-10s%-10s%-10s%-12s\n\n", "Month", "Balance", "Payment", "Paid", "Paid",
				"Balance");
	}

	public void consolePrintSchedule(OutFinancialFlowBean outFinancialFlowBean) {

		if (outFinancialFlowBean != null && !outFinancialFlowBean.getTermBeanList().isEmpty()) {
			for (TermBean termBean : outFinancialFlowBean.getTermBeanList()) {
				System.out.format(termBean.getTermNumber() + "/" + termBean.getFinancialAmount() + "/"
						+ termBean.getMonthlyPayment() + "/" + termBean.getMonthlyInterest() + "/"
						+ termBean.getPrincipalPaid() + "/" + termBean.getNewbalance() + "\n");
			}
		}
	}

}
