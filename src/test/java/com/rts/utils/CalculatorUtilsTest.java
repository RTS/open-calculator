/**
 * 
 */
package com.rts.utils;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author rts
 *
 */
public class CalculatorUtilsTest {

	/**
	 * Test method for
	 * {@link com.rts.utils.CalculatorUtils#presentValue(double, double, double)}
	 * .
	 */
	@Test
	public final void testPresentValue() {
		System.out.println("Present value : " + new BigDecimal(CalculatorUtils.presentValue(0.01, 36, 830.36)).toPlainString());
	}

	/**
	 * Test method for
	 * {@link com.rts.utils.CalculatorUtils#futureValue(double, double, double)}
	 * .
	 */
	@Test
	public final void testFutureValue() {
		System.out.println("Future value : " + new BigDecimal(CalculatorUtils.futureValue(0.01, 36, 830.36)).toPlainString());
	}

	/**
	 * Test method for
	 * {@link com.rts.utils.CalculatorUtils#netPresentValue(double, double, double)}
	 * .
	 */
	@Test
	public final void testNetPresentValue() {
		System.out.println(
				"Net present value : " + new BigDecimal(CalculatorUtils.netPresentValue(0.01, 36, 35769.31)).toPlainString());
	}

	/**
	 * Test method for
	 * {@link com.rts.utils.CalculatorUtils#duration(double, double, double)}.
	 */
	@Test
	public final void testDuration() {
		System.out.println("Duration : " + CalculatorUtils.duration(0.01, 830.36, 25000));
	}

	/**
	 * Test method for
	 * {@link com.rts.utils.CalculatorUtils#annuityPayment(double, double, double)}
	 * .
	 */
	@Test
	public final void testAnnuityPayment() {
		System.out.println("Payment : " + new BigDecimal(CalculatorUtils.annuityPayment(0.01, 36, 25000)).toPlainString());
	}

	/**
	 * Test method for
	 * {@link com.rts.utils.CalculatorUtils#interestRate(double, double, double)}
	 * .
	 */
	@Test
	public final void testInterestRate() {
		System.out.println("Interest rate : " + new BigDecimal(CalculatorUtils.interestRate(36, 830.36, 25000)).toPlainString());

	}

}
