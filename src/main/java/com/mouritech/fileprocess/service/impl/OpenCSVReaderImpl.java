package com.mouritech.fileprocess.service.impl;

import com.mouritech.fileprocess.service.OpenCSVReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.List;

/**
 * 
 * @author sivave
 *
 * This class is used to perform read operations on CSV files 
 */
public class OpenCSVReaderImpl implements OpenCSVReader {

    Logger logger = LoggerFactory.getLogger(OpenCSVReaderImpl.class);

    @Override
    public List<String[]> readCsv(String inputFilePath) {
        List<String[]> allData=null;

        try(CSVReader csvReader = new CSVReader(new FileReader(inputFilePath)))
        {
            allData = csvReader.readAll();

        }catch (Exception e){
            logger.error("Exception while reading csv {} ", e.getMessage());
        }

        return allData;
    }

    @Override
	public List<String[]> readCsv(String inputFilePath, int skipLine) {
		List<String[]> allData = null;
		try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(skipLine)
				.build()) {

			allData = csvReader.readAll();

		} catch (Exception e) {
			logger.error("Exception while reading csv with skipline {} ", e.getMessage());
		}

		return allData;
	}

    @Override
	public List<String[]> readCsv(String inputFilePath, char separator) {
		List<String[]> allData = null;

		CSVParser parser = new CSVParserBuilder().withSeparator(separator).withIgnoreQuotations(false)
				.build();
		
		try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withCSVParser(parser)
				.build()) {
		
			allData = csvReader.readAll();
			
		} catch (Exception e) {
			logger.error("Exception while reading with separator {}", e.getMessage());
		}
		return allData;
	}

    @Override
	public List<String[]> readCsv(String inputFilePath, int skipLine, char separator) {
		List<String[]> allData = null;
		CSVParser parser = new CSVParserBuilder().withSeparator(separator).withIgnoreQuotations(false).build();
		
		try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(inputFilePath)).withSkipLines(skipLine)
				.withCSVParser(parser).build()) {
			
			allData = csvReader.readAll();
			
		} catch (Exception e) {
			logger.error("Exception while reading skip line and separator {}", e.getMessage());
		}
		return allData;
	}
}
