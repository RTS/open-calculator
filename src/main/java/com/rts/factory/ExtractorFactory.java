package com.rts.factory;

import com.rts.extractors.Extractor;
import com.rts.extractors.impl.ConsoleExtractor;
import com.rts.extractors.impl.CsvExtractor;

public class ExtractorFactory {

	private static final ExtractorFactory EXTRACTOR_FACTORY = new ExtractorFactory();

	public static ExtractorFactory getInstance() {
		return EXTRACTOR_FACTORY;
	}

	private ExtractorFactory() {
	}

	public Extractor getExtractor(int extractorType) {

		switch (extractorType) {
			case 1:
				return ConsoleExtractor.getInstance();
			case 2:
				return CsvExtractor.getInstance();
			case 3:
				// XML
			case 4:
				// JSON
			default:
				return null;
		}
	}

}
