package com.rts.calculator;

import java.util.ArrayList;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;

/**
 * 
 * @author rts
 *
 */
public abstract class FinancialEngine {

	public static final int	LOAN_V1	= 1;
	public static final int	LOAN_V2	= 2;

	public abstract OutFinancialFlowBean compute(InFinancialFlowBean inFinancialFlowBean);

	/**
	 * @param outFinancialFlowBean
	 * @param termBean
	 */
	protected void addNewTerm(OutFinancialFlowBean outFinancialFlowBean, TermBean termBean) {
		if (outFinancialFlowBean.getTermBeanList() == null) {
			outFinancialFlowBean.setTermBeanList(new ArrayList<TermBean>());
		}
		outFinancialFlowBean.getTermBeanList().add(termBean);
	}

	/**
	 * 
	 * @param paymentNumber
	 * @param financialAmount
	 * @param paymentAmount
	 * @param interestPaid
	 * @param principalPaid
	 * @param remainingBalance
	 * @return TermBean
	 */
	protected TermBean initTerm(int paymentNumber, double financialAmount, double paymentAmount, double interestPaid,
			double principalPaid, double remainingBalance) {
		TermBean termBean = new TermBean();

		termBean.setPaymentNumber(paymentNumber);
		termBean.setFinancialAmount(financialAmount);
		termBean.setPaymentAmount(paymentAmount);
		termBean.setInterestPaid(interestPaid);
		termBean.setPrincipalPaid(principalPaid);
		termBean.setRemainingBalance(remainingBalance);

		return termBean;
	}

	/**
	 * 
	 * @param inFinancialFlowBean
	 * @return int
	 */
	protected int getMonthlyDuration(InFinancialFlowBean inFinancialFlowBean) {
		int monthlyDuration = 0;
		if (inFinancialFlowBean.getYearlyDuration() != null) {
			monthlyDuration = inFinancialFlowBean.getYearlyDuration() * 12;
		} else if (inFinancialFlowBean.getMonthlyDuration() != null) {
			monthlyDuration = inFinancialFlowBean.getMonthlyDuration();
		}
		return monthlyDuration;
	}

	/**
	 * 
	 * @param inFinancialFlowBean
	 * @return double
	 */
	protected double getMonthlyInterestRate(InFinancialFlowBean inFinancialFlowBean) {
		double monthlyInterestRate = .0;
		if (inFinancialFlowBean.getYearlyInterestRate() != null) {
			monthlyInterestRate = (inFinancialFlowBean.getYearlyInterestRate() / 12) / 100;
		} else if (inFinancialFlowBean.getMonthlyInterestRate() != null) {
			monthlyInterestRate = inFinancialFlowBean.getMonthlyInterestRate() / 100;
		}
		return monthlyInterestRate;
	}

	/**
	 * 
	 * @param inFinancialFlowBean
	 * @return double
	 */
	protected double getFinancialAmount(InFinancialFlowBean inFinancialFlowBean) {
		double financialAmount = .0;
		if (inFinancialFlowBean.getFinancialAmount() != null) {
			financialAmount = inFinancialFlowBean.getFinancialAmount();
		}
		return financialAmount;
	}

	/**
	 * 
	 * @param interestRate
	 * @param duration
	 * @param amount
	 * @return double
	 */
	protected double getPresentValue(double interestRate, int duration, double amount) {
		return getNetPresentValue(interestRate, duration, getFutureValue(interestRate, duration, amount));
	}

	/**
	 * 
	 * @param interestRate
	 * @param duration
	 * @param amount
	 * @return double
	 */
	protected double getFutureValue(double interestRate, int duration, double amount) {

		if (interestRate <= 0) {
			return duration * amount;
		}

		return (amount / interestRate) * (Math.pow((1 + interestRate), duration) - 1);
	}

	/**
	 * 
	 * @param interestRate
	 * @param duration
	 * @param amount
	 * @return double
	 */
	protected double getNetPresentValue(double interestRate, int duration, double amount) {

		if (interestRate == -1) {
			return 0;
		}
		return (amount / Math.pow((1 + interestRate), duration));
	}

	// ln(1+interestRate)-ln(1-((financialAmount*interestRate)/monthlyPayment))
	/**
	 * 
	 * @param interestRate
	 * @param periodicAmount
	 * @param fullAmount
	 * @return int
	 */
	protected int getDuration(double interestRate, double periodicAmount, double fullAmount) {

		if (interestRate == 0 && periodicAmount != 0) {
			return (int) (fullAmount / periodicAmount);
		}

		int duration = 2048;
		double iteration = 1024;
		double tempPeriodicAmount = periodicAmount;

		for (int i = 1; i < 50; i++) {
			tempPeriodicAmount = getPeriodicPayment(interestRate, duration, fullAmount);
			if (tempPeriodicAmount == periodicAmount) {
				return duration;
			} else {
				if (tempPeriodicAmount < periodicAmount) {
					duration -= iteration;
				} else {
					duration += iteration;
				}
			}
			iteration = iteration / 2;
		}
		return duration;
	}

	/**
	 * 
	 * @param interestRate
	 * @param duration
	 * @param amount
	 * @return double
	 */
	protected double getPeriodicPayment(double interestRate, int duration, double amount) {

		if (duration <= 0) {
			return amount;
		} else if (duration <= 1) {
			return amount * (1 + interestRate);
		} else if (interestRate == 0) {
			return amount / duration;
		}

		return (amount * interestRate) / (1 - Math.pow((1 + interestRate), (duration * (-1))));
	}

	/**
	 * 
	 * @param duration
	 * @param periodicAmount
	 * @param fullAmount
	 * @return double
	 */
	protected double getInterestRate(int duration, double periodicAmount, double fullAmount) {

		double interestRate = 0;
		double iteration = 1;
		double tempPeriodicAmount = periodicAmount;

		for (int i = 1; i < 50; i++) {
			tempPeriodicAmount = getPeriodicPayment(interestRate, duration, fullAmount);
			if (tempPeriodicAmount == periodicAmount) {
				return interestRate;
			} else {
				if (tempPeriodicAmount < periodicAmount) {
					interestRate += iteration;
				} else {
					interestRate -= iteration;
				}
			}
			iteration = iteration / 2;
		}
		return interestRate;
	}
}
