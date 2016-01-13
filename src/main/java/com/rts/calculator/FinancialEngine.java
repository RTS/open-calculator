package com.rts.calculator;

import java.util.ArrayList;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;

public class FinancialEngine {

	private static final FinancialEngine FINANCIAL_ENGINE = new FinancialEngine();

	public static FinancialEngine getInstance() {
		return FINANCIAL_ENGINE;
	}

	private FinancialEngine() {
	}

	public OutFinancialFlowBean compute(InFinancialFlowBean inFinancialFlowBean) {

		// init output
		OutFinancialFlowBean outFinancialFlowBean = new OutFinancialFlowBean();
		outFinancialFlowBean.setInFinancialFlowBean(inFinancialFlowBean);

		double financialAmount = this.getFinancialAmount(inFinancialFlowBean);
		double monthlyInterestRate = this.getMonthlyInterestRate(inFinancialFlowBean);
		int monthlyDuration = this.getMonthlyDuration(inFinancialFlowBean);

		double monthlyPayment = .0, monthlyInterest = .0, principalPaid = .0;

		// calculation function
		monthlyPayment = financialAmount * monthlyInterestRate
				* Math.pow(1 + monthlyInterestRate, (double) monthlyDuration)
				/ (Math.pow(1 + monthlyInterestRate, (double) monthlyDuration) - 1);

		int termNumber;
		for (termNumber = 1; termNumber < monthlyDuration; termNumber++) {
			monthlyInterest = financialAmount * monthlyInterestRate;
			principalPaid = monthlyPayment - monthlyInterest;

			TermBean termBean = this.initTerm(financialAmount, monthlyPayment, monthlyInterest, principalPaid,
					termNumber);

			this.addNewTerm(outFinancialFlowBean, termBean);

			financialAmount -= principalPaid;
		}

		// last month
		TermBean termBean = this.initTerm(financialAmount, financialAmount + monthlyInterest,
				financialAmount * monthlyInterestRate, financialAmount, termNumber);

		this.addNewTerm(outFinancialFlowBean, termBean);

		return outFinancialFlowBean;
	}

	/**
	 * @param outFinancialFlowBean
	 * @param termBean
	 */
	private void addNewTerm(OutFinancialFlowBean outFinancialFlowBean, TermBean termBean) {
		if (outFinancialFlowBean.getTermBeanList() == null) {
			outFinancialFlowBean.setTermBeanList(new ArrayList<TermBean>());
		}
		outFinancialFlowBean.getTermBeanList().add(termBean);
	}

	/**
	 * @param financialAmount
	 * @param monthlyPayment
	 * @param monthlyInterest
	 * @param principalPaid
	 * @param termNumber
	 * @return
	 */
	private TermBean initTerm(double financialAmount, double monthlyPayment, double monthlyInterest,
			double principalPaid, int termNumber) {
		TermBean termBean = new TermBean();
		termBean.setTermNumber(termNumber);
		termBean.setFinancialAmount(financialAmount);
		termBean.setMonthlyPayment(monthlyPayment);
		termBean.setMonthlyInterest(monthlyInterest);
		termBean.setPrincipalPaid(principalPaid);
		termBean.setNewbalance(financialAmount - principalPaid);
		return termBean;
	}

	private int getMonthlyDuration(InFinancialFlowBean inFinancialFlowBean) {
		int monthlyDuration = 0;
		if (inFinancialFlowBean.getYearlyDuration() != null) {
			monthlyDuration = inFinancialFlowBean.getYearlyDuration() * 12;
		} else if (inFinancialFlowBean.getMonthlyDuration() != null) {
			monthlyDuration = inFinancialFlowBean.getMonthlyDuration();
		}
		return monthlyDuration;
	}

	private double getMonthlyInterestRate(InFinancialFlowBean inFinancialFlowBean) {
		double monthlyInterestRate = .0;
		if (inFinancialFlowBean.getYearlyInterestRate() != null) {
			monthlyInterestRate = (inFinancialFlowBean.getYearlyInterestRate() / 12) / 100;
		} else if (inFinancialFlowBean.getMonthlyInterestRate() != null) {
			monthlyInterestRate = inFinancialFlowBean.getMonthlyInterestRate() / 100;
		}
		return monthlyInterestRate;
	}

	private double getFinancialAmount(InFinancialFlowBean inFinancialFlowBean) {
		double financialAmount = .0;
		if (inFinancialFlowBean.getFinancialAmount() != null) {
			financialAmount = inFinancialFlowBean.getFinancialAmount();
		}
		return financialAmount;
	}

}
