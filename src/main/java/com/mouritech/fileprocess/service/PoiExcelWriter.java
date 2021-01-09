package com.mouritech.fileprocess.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author sivave
 *
 * Generate Excel file using Apache POI
 */
public interface PoiExcelWriter {

    void writeExcel(String filePath, Map<String, List<Object[]>> data);

}
