package com.rts.extractors;

import com.rts.beans.OutFinancialFlowBean;

public interface Extractor {

	public static final int	CONSOLE	= 1;
	public static final int	CSV		= 2;
	public static final int	XML		= 3;
	public static final int	JSON	= 4;

	void printHeader();

	void printSchedule(OutFinancialFlowBean outFinancialFlowBean);

}
