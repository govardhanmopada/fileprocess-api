package com.mouritech.fileprocess.service.impl;

import com.mouritech.fileprocess.service.PoiCSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PoiCSVReaderImpl implements PoiCSVReader {

	Logger logger = LoggerFactory.getLogger(PoiCSVReaderImpl.class);

	@Override
	public List<String[]> readCsv(String inputFilePath, boolean skipHeader) {

		List<String[]> allData = new ArrayList<>();
		CSVParser csvParser;

		try (Reader reader = Files.newBufferedReader(Paths.get(inputFilePath))) {

			if (skipHeader)
				csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
			else
				csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

			for (CSVRecord record : csvParser) {
				String[] arr = new String[record.size()];
				int i = 0;
				for (String str : record) {
					arr[i++] = str;
				}

				allData.add(arr);

			}
		} catch (Exception e) {
			logger.error("Exception while reading csv using poi {}", e.getMessage());
		}

		return allData;
	}

	@Override
	public List<String[]> readCsv(String inputFilePath, boolean skipHeader, char separator) {
		List<String[]> allData = new ArrayList<>();
		CSVParser csvParser;
		try (Reader reader = Files.newBufferedReader(Paths.get(inputFilePath))) {

			if (skipHeader) {
				CSVFormat.DEFAULT.withFirstRecordAsHeader();
				csvParser = new CSVParser(reader, CSVFormat.newFormat(separator));
			} else
				csvParser = new CSVParser(reader, CSVFormat.newFormat(separator));

			for (CSVRecord record : csvParser) {
				String[] arr = new String[record.size()];
				int i = 0;
				for (String str : record) {
					arr[i++] = str;
				}

				allData.add(arr);
			}
		} catch (Exception e) {
			logger.error("Exception while reading csv file {}", e.getMessage());
		}

		return allData;
	}
}
