package com.mouritech.fileprocess.service.impl;

import com.mouritech.fileprocess.service.OpenCSVWriter;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class OpenCSVWriterImpl implements OpenCSVWriter {

    Logger logger = LoggerFactory.getLogger(OpenCSVWriterImpl.class);

    @Override
    public void writeCsv(String outputFilePath, List<String[]> data, char separator)  {
		try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8), 
					separator, '\u0000', '\u0000', "\n")) {
			for (String[] array : data) {
				writer.writeNext(array);
			}
		} catch (Exception e) {
			logger.error("Exception while writing csv with mentioned separator {} ", e.getMessage());
		}
    }

    @Override
    public void writeCsv(String outputFilePath,List<String[]> data) {
		try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8), 
					',', '\u0000', '\u0000', "\n")) {
			for (String[] array : data) {
				writer.writeNext(array);
			}
		} catch (Exception e) {
			logger.error("Exception while writing csv {} ", e.getMessage());

		}
	}
}
