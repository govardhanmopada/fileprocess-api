package com.mouritech.fileprocess.service;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @author sivave
 *
 * Generate CSV files using Apache POI
 */
public interface PoiCSVWriter {

	/**
	 * Generate CSV using file path and data
	 * @param outputFilePath
	 * @param data
	 */
    void writeCsv(String outputFilePath, List<String[]> data);

    /**
     * Generate CSV using file path, data and separator
     * 
     * @param outputFilePath
     * @param data
     * @param separator
     * @throws IOException
     */
    void writeCsv(String outputFilePath,List<String[]> data,char separator) throws IOException;

}
