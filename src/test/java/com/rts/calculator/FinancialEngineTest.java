/**
 * 
 */
package com.rts.calculator;

import org.junit.Test;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.calculator.factory.FinancialEngineFactory;
import com.rts.extractors.Extractor;
import com.rts.extractors.factory.ExtractorFactory;

public class FinancialEngineTest {

	// @Test
	public final void testLoanCalculator() {
		InFinancialFlowBean inFinancialFlowBean = new InFinancialFlowBean();

		inFinancialFlowBean.setMonthlyInterestRate(1.0);
		inFinancialFlowBean.setFinancialAmount(25000.0);
		inFinancialFlowBean.setMonthlyDuration(36);

		OutFinancialFlowBean outFinancialFlowBean = FinancialEngineFactory.getInstance().getFinancialEngine(FinancialEngine.LOAN)
				.compute(inFinancialFlowBean);

		// ExtractorFactory.getInstance().getExtractor(Extractor.CSV).printSchedule(outFinancialFlowBean);

		ExtractorFactory.getInstance().getExtractor(Extractor.CONSOLE).printSchedule(outFinancialFlowBean);
	}

	@Test
	public final void testInitialFinancialAmountCalculator() {
		InFinancialFlowBean inFinancialFlowBean = new InFinancialFlowBean();

		inFinancialFlowBean.setMonthlyInterestRate(2.0);
		inFinancialFlowBean.setFinancialAmount(25000.0);
		inFinancialFlowBean.setMonthlyDuration(36);

		OutFinancialFlowBean outFinancialFlowBean = FinancialEngineFactory.getInstance()
				.getFinancialEngine(FinancialEngine.INITIAL_FINANCIAL_AMOUNT).compute(inFinancialFlowBean);

	}

}
