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

	@Test
	public final void testLoanCalculatorV1() {
		InFinancialFlowBean inFinancialFlowBean = new InFinancialFlowBean();

		inFinancialFlowBean.setMonthlyInterestRate(1.0);
		inFinancialFlowBean.setFinancialAmount(25000.0);
		inFinancialFlowBean.setMonthlyDuration(36);

		OutFinancialFlowBean outFinancialFlowBean = FinancialEngineFactory.getInstance()
				.getFinancialEngine(FinancialEngine.LOAN_V1).compute(inFinancialFlowBean);

		// ExtractorFactory.getInstance().getExtractor(Extractor.CSV).printSchedule(outFinancialFlowBean);

		ExtractorFactory.getInstance().getExtractor(Extractor.CONSOLE).printSchedule(outFinancialFlowBean);
	}

	public final void testLoanCalculatorV2() {
		InFinancialFlowBean inFinancialFlowBean = new InFinancialFlowBean();

		inFinancialFlowBean.setMonthlyInterestRate(1.0);
		inFinancialFlowBean.setFinancialAmount(25000.0);
		inFinancialFlowBean.setMonthlyDuration(36);

		OutFinancialFlowBean outFinancialFlowBean = FinancialEngineFactory.getInstance()
				.getFinancialEngine(FinancialEngine.LOAN_V2).compute(inFinancialFlowBean);

		ExtractorFactory.getInstance().getExtractor(Extractor.CONSOLE).printSchedule(outFinancialFlowBean);

	}

}
