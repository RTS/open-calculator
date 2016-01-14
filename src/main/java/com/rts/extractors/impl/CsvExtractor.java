package com.rts.extractors.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.rts.beans.OutFinancialFlowBean;
import com.rts.beans.TermBean;
import com.rts.extractors.Extractor;
import com.rts.utils.AmountFormatter;

public class CsvExtractor implements Extractor {

	private static final Logger			LOGGER					= Logger.getLogger(CsvExtractor.class);
	private static final CsvExtractor	CSV_EXTRACTOR			= new CsvExtractor();

	private int							defaultDecimalPrecision	= 2;
	private String						fileCreationPath		= "c:\\temp";
	private String						fileName				= "temp.cvs";
	private FileWriter					fileWriter;

	public static CsvExtractor getInstance() {
		return CSV_EXTRACTOR;
	}

	private CsvExtractor() {
	}

	@Override
	public void printHeader() {

		this.initFileWriter();

		fileWriter.append("N°, Financial amount, Monthly payment, Monthly interest, Principal paid, New balance %n");

		this.finishWriting();
	}

	@Override
	public void printSchedule(OutFinancialFlowBean outFinancialFlowBean) {

		this.initFileWriter();

		if (outFinancialFlowBean != null && !outFinancialFlowBean.getTermBeanList().isEmpty()) {
			for (TermBean termBean : outFinancialFlowBean.getTermBeanList()) {
				fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getTermNumber(), defaultDecimalPrecision)));
				fileWriter.append(", ");
				fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getFinancialAmount(), defaultDecimalPrecision)));
				fileWriter.append(", ");
				fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getMonthlyPayment(), defaultDecimalPrecision)));
				fileWriter.append(", ");
				fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getMonthlyInterest(), defaultDecimalPrecision)));
				fileWriter.append(", ");
				fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getPrincipalPaid(), defaultDecimalPrecision)));
				fileWriter.append(", ");
				fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getNewbalance(), defaultDecimalPrecision)));
			}
		}

		this.finishWriting();

	}

	/**
	 * @throws IOException
	 */
	private void initFileWriter() throws IOException {

		if (fileWriter == null) {
			fileWriter = new FileWriter(fileCreationPath + fileName);
		}
	}

	/**
	 * @throws IOException
	 */
	private void finishWriting() throws IOException {
		fileWriter.flush();
		fileWriter.close();
	}

}
