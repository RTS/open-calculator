package com.rts.calculator;

import java.math.BigDecimal;

import org.junit.Test;

import com.rts.utils.CalculatorUtils;

public class CalculatorUtilsTest {

	@Test
	public final void testPresentValue() {
		System.out.println("Present value : " + new BigDecimal(CalculatorUtils.presentValue(0.01, 36, 830.36)).toPlainString());
	}

	@Test
	public final void testFutureValue() {
		System.out.println("Future value : " + new BigDecimal(CalculatorUtils.futureValue(0.01, 36, 830.36)).toPlainString());
	}

	@Test
	public final void testNetPresentValue() {
		System.out.println(
				"Net present value : " + new BigDecimal(CalculatorUtils.netPresentValue(0.01, 36, 35769.31)).toPlainString());

	}

}
