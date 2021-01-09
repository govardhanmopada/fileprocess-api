package com.mouritech.fileprocess.service.impl;

import com.mouritech.fileprocess.service.PoiCSVWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PoiCSVWriterImpl implements PoiCSVWriter {
    Logger logger = LoggerFactory.getLogger(PoiCSVWriterImpl.class);

    @Override
    public void writeCsv(String outputFilePath, List<String[]> data, char separator)  {

    	try(Writer writer =Files.newBufferedWriter(Paths.get(outputFilePath));
            CSVPrinter csvPrinter= new CSVPrinter(writer,CSVFormat.DEFAULT.withDelimiter(separator).withQuote(null))){

            for(Object[] raw : data) {

                csvPrinter.printRecord(raw);
            }
            csvPrinter.flush();

        }catch (Exception e){
            logger.error("Exception e while writing {}", e.getMessage());
        }
    }

    @Override
    public void writeCsv(String outputFilePath, List<String[]> data) {

        try(Writer writer = Files.newBufferedWriter(Paths.get(outputFilePath));
                CSVPrinter csvPrinter= new CSVPrinter(writer, CSVFormat.DEFAULT.withQuote(null))){

        	for(Object[] raw : data) {
                csvPrinter.printRecord(raw);
            }
            
        	csvPrinter.flush();
        }catch (Exception e){
            logger.error("Exception e while writing {}", e.getMessage());
        }
    }
}
