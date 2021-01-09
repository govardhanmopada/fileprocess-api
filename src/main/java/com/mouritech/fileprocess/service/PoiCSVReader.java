package com.mouritech.fileprocess.service;

import java.io.IOException;
import java.util.List;

/**
 * 
 * @author sivave
 *
 * Reading CSV files using Apache POI
 */
public interface PoiCSVReader {

	/**
	 * Read CSV file using file path and skipHeader
	 * @param inputFilePath
	 * @param skipHeader
	 * @return
	 * @throws IOException
	 */
    List<String[]> readCsv(String inputFilePath, boolean skipHeader)throws IOException;

    /**
     * Read CSV file using file path, skip header and separator
     * @param inputFilePath
     * @param skipHeader
     * @param separator
     * @return
     * @throws IOException
     */
    List<String[]> readCsv(String inputFilePath, boolean skipHeader,char separator)throws IOException;

}
