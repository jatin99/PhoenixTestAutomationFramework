package com.api.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtil {

	public static void main(String[] args) throws IOException {
		// APACHE POI OOXML LIB
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("testData/PhoenixTestData.xlsx");
		XSSFWorkbook myWorkBook = new XSSFWorkbook(is);
		// Focus on the Sheet

		XSSFSheet mySheet = myWorkBook.getSheet("LoginTestData");
		XSSFRow myRow ;
		XSSFCell myCell ;
	
		
		int lastRowIndex=mySheet.getLastRowNum();
		System.out.println(lastRowIndex);
		
		XSSFRow rowHeader = mySheet.getRow(0);
		int lastIndexOfCol=rowHeader.getLastCellNum()-1;//return the total number of Cols
		System.out.println(lastIndexOfCol);
		
		
		for(int rowIndex= 0; rowIndex<=lastRowIndex; rowIndex++) {
			for(int colIndex=0; colIndex<=lastIndexOfCol; colIndex++) {
				myRow= mySheet.getRow(rowIndex);
				myCell = myRow.getCell(colIndex);
				System.out.print(myCell +" ");
			}
			System.out.println("");
		}
		
	}

}
