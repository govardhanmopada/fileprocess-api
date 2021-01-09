package com.mouritech.fileprocess.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author sivave
 *
 * Read Excel file using Apache POI
 */
public interface PoiExcelReader {

    Map<String, List<Object[]>> readExcelData(String excelFilePath);

}
