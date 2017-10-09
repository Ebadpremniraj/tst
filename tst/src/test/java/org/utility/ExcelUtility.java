package org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
		//private static String[][] tabArray = null;
		private Workbook wrkbook =null;
		File fl;
		public ExcelUtility(String xlFilePath) throws FileNotFoundException {
			try {
				fl = new File(xlFilePath);
				FileInputStream fisObj = new FileInputStream(fl);
				wrkbook = new XSSFWorkbook(fisObj);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
		}
		
	 public String[][] getDataFromExcel(String sheetName) throws Exception {
			// Declare a 2 dimensions array to store all the test data read from
			// excel
	    	Row row;
			String[][] tabArray = null;
			int rowcount,colcount;
			Sheet wrkSheet = wrkbook.getSheet(sheetName);
			rowcount = wrkSheet.getLastRowNum()+1;
			colcount = wrkSheet.getRow(0).getLastCellNum();
			tabArray = new String[rowcount][colcount];
			for (int i=1;i<rowcount;i++){
				row = wrkSheet.getRow(i);
				for(int j=0;j<colcount;j++){
					tabArray[i][j]=row.getCell(j).getStringCellValue();
				}
			}
			return (tabArray);
		}		
	public void getSheet(String sheetName) {
		wrkbook.getSheet(sheetName);
	}
	
	 public String getCellData(int rowNo, String colName, String sheetName) {
		 String data = null,cellName;
		 Row row;
		 int rowcount,colcount;
		 Sheet wrkSheet = wrkbook.getSheet(sheetName);
		 rowcount = wrkSheet.getLastRowNum()+1;
		 colcount = wrkSheet.getRow(0).getLastCellNum();
		 if (rowNo>rowcount|rowNo==0) {
			 System.out.println("RowNo should be less than rowcount of excel file and greater than 0");
			 return "-1";
		 }
		 else {
			 row = wrkSheet.getRow(0);
			 for(int i=0;i<colcount;i++) {
				 cellName = row.getCell(i).getStringCellValue();
				 if(cellName.matches(colName)) {
					 row =  wrkSheet.getRow(rowNo);
					 data = row.getCell(i).getStringCellValue(); 
					break;
				 }
				 else {
					 data = null;
				 }
			 }
		 }
		 return data;
	 }
	//Function to read total no  of rows in an excelsheet
	 public int getRowCount(String sheetName) {		
		 Sheet wrkSheet = wrkbook.getSheet(sheetName);
		 return ( wrkSheet.getLastRowNum()+1);
	}
	//@SuppressWarnings("null")
	public String[] getRowData(int rowNo,String sheetName) {
		//String[] data = null ;
		Row row;
		 int rowcount,colcount;
		 Sheet wrkSheet = wrkbook.getSheet(sheetName);
		 rowcount = wrkSheet.getLastRowNum()+1;
		 colcount = wrkSheet.getRow(0).getLastCellNum();
		 String[] data = new String[colcount];
		 if (rowNo>rowcount||rowNo==0) {
			 System.out.println("RowNo should be less than rowcount of excel file and greater than 0");
			 return null;
		 }
		 else {
			 row = wrkSheet.getRow(rowNo);
			 for(int i=0;i<colcount;i++) {
				data[i]=row.getCell(i).getStringCellValue();
			 }
		 }
		
		return data;
	}
	
//	function to set the data in the excel
	public void setCelldata(int rowNo, String value, String columnName, String sheetName) throws IOException
	{
		int rowCount, columnCount, columnNumber;
		String excelColumnname;
		boolean flag =false;
		Row row;
		Sheet workSheet = wrkbook.getSheet(sheetName);
		rowCount = workSheet.getLastRowNum();
		columnCount = workSheet.getRow(0).getLastCellNum();
		if (rowNo>rowCount|rowNo==0) 
		{
			 System.out.println("RowNo should be less than rowcount of excel file and greater than 0");
		}
		else
		{
			row = workSheet.getRow(0);
			for (int i=0; i<columnCount; i++)
			{
				excelColumnname	= row.getCell(i).getStringCellValue();
				if (columnName.equals(excelColumnname))
				{
					columnNumber 	= i;
					flag 			= true;
					row 			= workSheet.getRow(rowNo);
					Cell cell 		= row.createCell(columnNumber);
					cell.setCellValue(value);
					break;
				}
			}
			if (flag == false)
			{
				row 			= workSheet.getRow(0);
				columnNumber 	= columnCount;
				Cell cell 		= row.createCell(columnNumber);
				cell.setCellValue(columnName);
				row 			= workSheet.getRow(rowNo);
				cell 			= row.createCell(columnNumber);
				cell.setCellValue(value);
			}
			FileOutputStream fileOutStream = new FileOutputStream(fl);
			wrkbook.write(fileOutStream);
			fileOutStream.close();
		}
	}
}
