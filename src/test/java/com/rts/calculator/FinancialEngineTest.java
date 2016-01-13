/**
 * 
 */
package com.rts.calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.extractors.ConsoleExtractor;

/**
 * @author rts
 *
 */
public class FinancialEngineTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.rts.calculator.FinancialEngine#compute(com.rts.beans.InFinancialFlowBean)}
	 * .
	 */
	@Test
	public final void testCompute() {
		InFinancialFlowBean inFinancialFlowBean = new InFinancialFlowBean();

		inFinancialFlowBean.setMonthlyInterestRate(1.0);
		inFinancialFlowBean.setFinancialAmount(25000.0);
		inFinancialFlowBean.setMonthlyDuration(36);

		FinancialEngine financialEngine = FinancialEngine.getInstance();
		OutFinancialFlowBean outFinancialFlowBean = financialEngine.compute(inFinancialFlowBean);

		ConsoleExtractor consoleExtractor = ConsoleExtractor.getInstance();
		consoleExtractor.consolePrintHeader();
		consoleExtractor.consolePrintSchedule(outFinancialFlowBean);
	}

}
