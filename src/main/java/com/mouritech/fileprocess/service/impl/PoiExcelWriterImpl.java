package com.mouritech.fileprocess.service.impl;

import com.mouritech.fileprocess.service.PoiExcelWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PoiExcelWriterImpl implements PoiExcelWriter {

	Logger logger = LoggerFactory.getLogger(PoiExcelWriterImpl.class);

    @Override
    public void writeExcel(String filePath, Map<String, List<Object[]>> data){

    	XSSFWorkbook workbook = new XSSFWorkbook();
        try (FileOutputStream out = new FileOutputStream(filePath)){
            Set<String> keyset = data.keySet();

            for (String sheetName:keyset){
            	List<Object[]> eachSheetData=data.get(sheetName);
                XSSFSheet sheet = workbook.createSheet(sheetName);
                int rownum = 0;
                
                for(Object[] sheetRow: eachSheetData) {
                    Row row = sheet.createRow(rownum++);
                    int cellnum = 0;

                    for (Object obj : sheetRow) {
                        Cell cell = row.createCell(cellnum++);
                        if (obj instanceof String)
                            cell.setCellValue((String) obj);
                        else if (obj instanceof Integer)
                            cell.setCellValue((Integer) obj);
                    }

                }
            }
            workbook.write(out);
            logger.info("Excel file generated successfully .");
        }catch (Exception e){
            logger.error("Exception e {}",e.getMessage());
        }
    }
}