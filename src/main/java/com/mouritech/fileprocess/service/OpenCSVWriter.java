package com.mouritech.fileprocess.service;

import java.io.IOException;
import java.util.List;

/**
 * @author sivave
 *
 * Generate CSV files using OpenCSV
 */
public interface OpenCSVWriter {
	
	/**
	 * Generate using file path, data and separator
	 * @param outputFilePath
	 * @param data
	 * @param separator
	 * @throws IOException
	 */
	void writeCsv(String outputFilePath, List<String[]> data, char separator) throws IOException;
	
	/**
	 * Generate using file path, data
	 * @param outputFilePath
	 * @param data
	 */
	void writeCsv(String outputFilePath, List<String[]> data);

}
