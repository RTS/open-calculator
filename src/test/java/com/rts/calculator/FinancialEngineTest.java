/**
 * 
 */
package com.rts.calculator;

import org.junit.Before;
import org.junit.Test;

import com.rts.beans.InFinancialFlowBean;
import com.rts.beans.OutFinancialFlowBean;
import com.rts.extractors.Extractor;
import com.rts.extractors.factory.ExtractorFactory;

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

		OutFinancialFlowBean outFinancialFlowBean = FinancialEngine.getInstance().compute(inFinancialFlowBean);

		Extractor extractor = ExtractorFactory.getInstance().getExtractor(Extractor.CSV);
		extractor.printSchedule(outFinancialFlowBean);
	}

}
