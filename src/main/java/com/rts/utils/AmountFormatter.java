package com.rts.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountFormatter {

	private static final AmountFormatter AMOUNT_FORMATTER = new AmountFormatter();

	public static AmountFormatter getInstance() {
		return AMOUNT_FORMATTER;
	}

	private AmountFormatter() {
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_EVEN);
		return bd.doubleValue();
	}

}
