package com.rts.utils;

public class Test {

	private static boolean		INPUT_YEARS			= false;
	private static boolean		BY_YEAR				= false;
	private static int			CALCULATE_THIS		= 4;

	private static double		NEW_LOAN_BALANCE	= 0;
	private static int			NEW_LOAN_TERM		= 0;
	private static double		NEW_LOAN_PAYMENT	= 0;
	private static double		NEW_LOAN_RATE		= 0;

	private static double[]		DR_NEW_BALANCE;
	private static double[]		DR_NEW_PRINCIPAL;
	private static double[]		DR_NEW_INTEREST;
	private static double[]		DR_LOAN_PAYMENT;

	private static final int	CALC_AMOUNT			= 1;
	private static final int	CALC_TERM			= 2;
	private static final int	CALC_RATE			= 3;
	private static final int	CALC_BALANCE		= 4;

	public static void main(String[] args) {

		NEW_LOAN_BALANCE = 25000;
		NEW_LOAN_TERM = 36;
		NEW_LOAN_RATE = 1;

		calculate();

		for (double d : DR_LOAN_PAYMENT) {
			System.out.println(d);
		}

	}

	public static double[] FloatArray(int d) {
		double[] b = new double[d];
		for (int c = 0; c < d; c++) {
			b[c] = 0;
		}
		return b;
	}

	public static double round(double b, double a) {
		return (a > 0 ? (Math.round(b * (Math.pow(10, a)))) / (Math.pow(10, a)) : Math.round(b));
	};

	public static double PV(double a, double c, double b) {
		return NPV_AMT(a, c, FV(a, c, b));
	}

	public static double FV(double a, double c, double b) {
		if (a == 0) {
			return c * b;
		}
		return (b / a) * (Math.pow((1 + a), c) - 1);
	}

	public static double NPV_AMT(double b, double c, double a) {
		if (b == -1) {
			return 0;
		}
		return (a / Math.pow((1 + b), c));
	}

	public static int PERIODS(double b, double c, double a) {
		if (b == 0 && c != 0) {
			return (int) (a / c);
		}
		int f = 3120;
		double h = 1560;
		double e = c;
		for (int g = 1; g < 50; g++) {
			e = PMT(b, f, a);
			if (e == c) {
				return f;
			} else {
				if (e < c) {
					f -= h;
				} else {
					f += h;
				}
			}
			h = h / 2;
		}
		return f;
	}

	public static double PMT(double a, double c, double b) {
		if (c <= 0) {
			return b;
		}
		if (c <= 1) {
			return b * (1 + a);
		}
		if (a == 0) {
			return b / c;
		}
		return (b * a) / (1 - Math.pow((1 + a), (c * (-1))));
	}

	public static double RATE(double h, double c, double b) {
		double a = 0;
		double g = 1;
		double e = c;
		for (int f = 1; f < 50; f++) {
			e = PMT(a, h, b);
			if (e == c) {
				return a;
			} else {
				if (e < c) {
					a += g;
				} else {
					a -= g;
				}
			}
			g = g / 2;
		}
		return a;
	}

	public static void calculate() {
		if (INPUT_YEARS) {
			NEW_LOAN_TERM = NEW_LOAN_TERM * 12;
		}
		if (CALCULATE_THIS == CALC_AMOUNT) {
			NEW_LOAN_BALANCE = round(PV(NEW_LOAN_RATE / 1200, NEW_LOAN_TERM, NEW_LOAN_PAYMENT) - 0.5, 0);
		} else {
			if (CALCULATE_THIS == CALC_TERM) {
				NEW_LOAN_TERM = PERIODS(NEW_LOAN_RATE / 1200, NEW_LOAN_PAYMENT, NEW_LOAN_BALANCE);
			} else {
				if (CALCULATE_THIS == CALC_RATE) {
					NEW_LOAN_RATE = RATE(NEW_LOAN_TERM, NEW_LOAN_PAYMENT, NEW_LOAN_BALANCE) * 1200;
				} else {
					NEW_LOAN_PAYMENT = round(PMT(NEW_LOAN_RATE / 1200, NEW_LOAN_TERM, NEW_LOAN_BALANCE), 2);
				}
			}
		}

		int monthlyDuration = Math.round(NEW_LOAN_TERM);

		DR_NEW_BALANCE = FloatArray(monthlyDuration);
		DR_NEW_PRINCIPAL = FloatArray(monthlyDuration);
		DR_NEW_INTEREST = FloatArray(monthlyDuration);
		DR_LOAN_PAYMENT = FloatArray(monthlyDuration);

		double interest = 0;
		double principal = 0;
		double balance = NEW_LOAN_BALANCE;
		double financialAmount = NEW_LOAN_PAYMENT;

		for (int i = 0; i < monthlyDuration; i++) {
			interest = round(NEW_LOAN_RATE / 1200 * balance, 2);
			principal = NEW_LOAN_PAYMENT - interest;
			balance -= principal;
			if (balance < 0) {
				financialAmount += balance;
				balance = 0;
				principal = financialAmount - interest;
			} else {
				financialAmount = NEW_LOAN_PAYMENT;
			}
			if (monthlyDuration - 1 == i) {
				if (balance > 0.005 || balance < 0.005) {
					financialAmount += balance;
					balance = 0;
					principal = financialAmount - interest;
				} else {
					balance = 0;
				}
			}

			if (BY_YEAR) {
				int e = (int) Math.floor(i / 12);
				DR_NEW_BALANCE[e] = balance;
				DR_NEW_INTEREST[e] += interest;
				DR_NEW_PRINCIPAL[e] += principal;
				DR_LOAN_PAYMENT[e] += interest + principal;
			} else {
				DR_NEW_BALANCE[i] = balance;
				DR_NEW_INTEREST[i] = interest;
				DR_NEW_PRINCIPAL[i] = principal;
				DR_LOAN_PAYMENT[i] = interest + principal;
			}
		}
	}

}
