package com.mouritech.fileprocess.service.impl;

import com.mouritech.fileprocess.service.PoiExcelReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.*;

public class PoiExcelReaderImpl implements PoiExcelReader {

    Logger logger = LoggerFactory.getLogger(PoiExcelReaderImpl.class);

    @Override
    public Map<String, List<Object[]>> readExcelData(String excelFilePath) {

        Workbook workbook ;
        Map<String, List<Object[]>> sheetWithData= new LinkedHashMap<>();
        try (FileInputStream inputStream = new FileInputStream(excelFilePath)){

        	workbook = new XSSFWorkbook(inputStream);
            int numberOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < numberOfSheets; i++) {
                Sheet aSheet = workbook.getSheetAt(i);

                Iterator<Row> iterator = aSheet.iterator();

                List<Object[]> eachSheet= new ArrayList<>();

                while (iterator.hasNext()) {

                    Row nextRow = iterator.next();
                    Object[] eachSheetData= new Object[nextRow.getLastCellNum()];
                    int cellCNt=0;

                    for (int cn=0; cn<nextRow.getLastCellNum(); cn++) {

                    	Cell cell = nextRow.getCell(cn);
                        if(null!=cell) {
                            switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_STRING:
                                    eachSheetData[cellCNt] = cell.getStringCellValue();
                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    eachSheetData[cellCNt] = cell.getStringCellValue();
                                    break;

                                case Cell.CELL_TYPE_NUMERIC:
                                    eachSheetData[cellCNt] = (int) cell.getNumericCellValue();
                                    break;
                                default:
                                    eachSheetData[cellCNt] = cell;
                                    break;
                            }
                        }
                        cellCNt++;
                    }

                    eachSheet.add(eachSheetData);
                }
                sheetWithData.put(aSheet.getSheetName(),eachSheet);

            }
        }catch (Exception e){
            logger.error("Exception e{}", e.getMessage());
        }
        return sheetWithData;
    }
}
