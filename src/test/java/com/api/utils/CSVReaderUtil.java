package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.dataproviders.api.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {
	/*
	 * 
	 * Constructor is private
	 * 
	 * static- static methods! Job: Help me Read the CSV file and Map it a Bean
	 *
	 */

	private CSVReaderUtil() {
		// No one can create Object of CSVReaderUtil Outside the Class
		// Singleton Class Constructors are private
	}

	public static void loadCSV(String pathOfCSVFile) {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOfCSVFile);
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvReader = new CSVReader(isr);

		CsvToBean<UserBean> csvToBean = new CsvToBeanBuilder(csvReader)
				.withType(UserBean.class)
				.withIgnoreEmptyLine(true)
				.build();

		List<UserBean> userList = csvToBean.parse();
		System.out.println(userList);

	}

}
