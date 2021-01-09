package com.mouritech.fileprocess.service;

import java.io.IOException;
import java.util.List;

/**
 * @author sivave
 * 
 * Reading CSV files using OpenCSV
 */
public interface OpenCSVReader {

	/**
	 * Read file using file path 
	 * @param inputFilePath
	 * @return
	 * @throws IOException
	 */
    List<String[]> readCsv(String inputFilePath)throws IOException;

    /**
     * Read file using file path and skipLine
     * @param inputFilePath
     * @param skipLine
     * @return
     * @throws IOException
     */
    List<String[]> readCsv(String inputFilePath,int skipLine)throws IOException;

    /**
     * Read file using file path and seperator
     * @param inputFilePath
     * @param separator
     * @return
     * @throws IOException
     */
    List<String[]> readCsv(String inputFilePath, char separator)throws IOException;
    
    /**
     * Read file using file path, skipline and separator
     * @param inputFilePath
     * @param skipLine
     * @param separator
     * @return
     * @throws IOException
     */
    List<String[]> readCsv(String inputFilePath,int skipLine,char separator)throws IOException;
}
