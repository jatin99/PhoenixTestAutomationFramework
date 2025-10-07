package com.demo.csv;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile_MapToPOJO {

	public static void main(String[] args) throws IOException, CsvException {

		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr); 
		
		//Write the code to Map the CSV to POJO
		
		CsvToBean<UserPOJO> csvToBean = new CsvToBeanBuilder(csvReader)
				.withType(UserPOJO.class)
				.withIgnoreEmptyLine(true)
				.build();
		
		
		List<UserPOJO> userList=csvToBean.parse();
		System.out.println(userList);
		
	}

}
