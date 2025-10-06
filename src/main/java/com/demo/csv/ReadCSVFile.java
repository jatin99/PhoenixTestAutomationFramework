package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile {

	public static void main(String[] args) throws IOException, CsvException {
	//Code to read the CSV file in Java!!! [Important Interview Question]
		/*
		 * 
		 * File csvFile = new File("C:\\Users\\HP\\eclipse-workspace\\PhoenixTestAutomationFramework\\src\\main\\resources\\testData\\LoginCreds.csv");
			FileReader fr = new FileReader(csvFile);
		 * 
		 * 
		 */
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr); //CSVReader Constructor
		//Requires a Reader!!
		
		List<String[]> dataList=csvReader.readAll();
		
		for( String[] dataArray :dataList) {
			
			System.out.println(dataArray[0]); //First Col Data
			System.out.println(dataArray[1]); //First Col Data
		}
		
		
		
	}

}
