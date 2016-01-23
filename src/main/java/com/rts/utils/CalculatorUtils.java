package com.rts.utils;

public class CalculatorUtils {

	public static double presentValue(double monthlyInterestRate, double monthlyDuration, double monthlyPaymentAmount) {
		return netPresentValue(monthlyInterestRate, monthlyDuration,

				futureValue(monthlyInterestRate, monthlyDuration, monthlyPaymentAmount));
	}

	public static double futureValue(double monthlyInterestRate, double monthlyDuration, double monthlyPaymentAmount) {

		if (monthlyInterestRate == 0) {
			return monthlyDuration * monthlyPaymentAmount;
		}

		return (monthlyPaymentAmount / monthlyInterestRate) * (Math.pow((1 + monthlyInterestRate), monthlyDuration) - 1);
	}

	public static double netPresentValue(double monthlyInterestRate, double monthlyDuration, double monthlyPaymentAmount) {

		if (monthlyInterestRate == -1) {
			return 0;
		}
		return (monthlyPaymentAmount / Math.pow((1 + monthlyInterestRate), monthlyDuration));
	}

	// ln(1+interestRate)-ln(1-((financialAmount*interestRate)/monthlyPayment))
	public static int duration(double monthlyInterestRate, double monthlyPaymentAmount, double financialAmount) {

		if (monthlyInterestRate == 0 && monthlyPaymentAmount != 0) {
			return (int) (financialAmount / monthlyPaymentAmount);
		}

		int monthlyDuration = 2048;
		double iteration = 1024;
		double tempMonthlyPaymentAmount = monthlyPaymentAmount;

		for (int i = 1; i < 50; i++) {
			tempMonthlyPaymentAmount = annuityPayment(monthlyInterestRate, monthlyDuration, financialAmount);
			if (tempMonthlyPaymentAmount == monthlyPaymentAmount) {
				return monthlyDuration;
			} else {
				if (tempMonthlyPaymentAmount < monthlyPaymentAmount) {
					monthlyDuration -= iteration;
				} else {
					monthlyDuration += iteration;
				}
			}
			iteration = iteration / 2;
		}
		return monthlyDuration;
	}

	public static double annuityPayment(double monthlyInterestRate, double monthlyDuration, double financialAmount) {

		if (monthlyDuration <= 0) {
			return financialAmount;
		} else if (monthlyDuration <= 1) {
			return financialAmount * (1 + monthlyInterestRate);
		} else if (monthlyInterestRate == 0) {
			return financialAmount / monthlyDuration;
		}

		return (financialAmount * monthlyInterestRate) / (1 - Math.pow((1 + monthlyInterestRate), (monthlyDuration * (-1))));
	}

	public static double interestRate(double monthlyDuration, double monthlyPaymentAmount, double financialAmount) {

		double monthlyInterestRate = 0;
		double iteration = 1;
		double tempMonthlyPaymentAmount = monthlyPaymentAmount;

		for (int i = 1; i < 50; i++) {
			tempMonthlyPaymentAmount = annuityPayment(monthlyInterestRate, monthlyDuration, financialAmount);
			if (tempMonthlyPaymentAmount == monthlyPaymentAmount) {
				return monthlyInterestRate;
			} else {
				if (tempMonthlyPaymentAmount < monthlyPaymentAmount) {
					monthlyInterestRate += iteration;
				} else {
					monthlyInterestRate -= iteration;
				}
			}
			iteration = iteration / 2;
		}
		return monthlyInterestRate;
	}

}
