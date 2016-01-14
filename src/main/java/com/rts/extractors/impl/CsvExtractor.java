package com.rts.extractors.impl;

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
	private String						fileCreationPath		= "/home/rts/";
	private String						fileName				= "temp.cvs";
	private FileWriter					fileWriter;

	public static CsvExtractor getInstance() {
		return CSV_EXTRACTOR;
	}

	private CsvExtractor() {
	}

	public void printSchedule(OutFinancialFlowBean outFinancialFlowBean) {

		this.initFileWriter();

		try {
			fileWriter.append("N°, Financial amount, Monthly payment, Monthly interest, Principal paid, New balance\n");

			if (outFinancialFlowBean != null && !outFinancialFlowBean.getTermBeanList().isEmpty()) {
				for (TermBean termBean : outFinancialFlowBean.getTermBeanList()) {
					fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getTermNumber(), defaultDecimalPrecision)));
					fileWriter.append(", ");
					fileWriter.append(
							String.valueOf(AmountFormatter.round(termBean.getFinancialAmount(), defaultDecimalPrecision)));
					fileWriter.append(", ");
					fileWriter
							.append(String.valueOf(AmountFormatter.round(termBean.getMonthlyPayment(), defaultDecimalPrecision)));
					fileWriter.append(", ");
					fileWriter.append(
							String.valueOf(AmountFormatter.round(termBean.getMonthlyInterest(), defaultDecimalPrecision)));
					fileWriter.append(", ");
					fileWriter
							.append(String.valueOf(AmountFormatter.round(termBean.getPrincipalPaid(), defaultDecimalPrecision)));
					fileWriter.append(", ");
					fileWriter.append(String.valueOf(AmountFormatter.round(termBean.getNewbalance(), defaultDecimalPrecision)));
					fileWriter.append("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.finishWriting();

	}

	/**
	 * @throws IOException
	 */
	private void initFileWriter() {

		try {
			if (fileWriter == null) {
				fileWriter = new FileWriter(fileCreationPath + fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws IOException
	 */
	private void finishWriting() {
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
