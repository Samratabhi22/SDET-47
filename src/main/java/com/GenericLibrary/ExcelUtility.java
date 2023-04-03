package com.GenericLibrary;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * This method is used to read the data from excel
	 * @param sheetname
	 * @param RowNo
	 * @param ColumnNo
	 * @return value
	 * @throws Throwable
	 * @author panth
	 */
	public String readDataFromExcel(String sheetname, int RowNo, int ColumnNo) throws Throwable
	{
		FileInputStream fi =new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		String value =sh.getRow(RowNo).getCell(ColumnNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to get the last row number
	 * @param sheetname
	 * @return count
	 * @throws Throwable
	 * @author panth
	 */
	public int getLastRowNo(String sheetname) throws Throwable
	{
		FileInputStream fi =new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fi);
		Sheet sh =wb.getSheet(sheetname);
		int count =sh.getLastRowNum();
		return count;
	}
	
	
	/**
	 * This method id used to write data into excel
	 * @param sheetname
	 * @param RowNO
	 * @param ColumnNo
	 * @throws Throwable
	 */
	
	public void writeDataIntoExcel(String sheetname, int RowNO, int ColumnNo, String data) throws Throwable
	{
		FileInputStream fi =new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
		sh.createRow(RowNO).createCell(ColumnNo).setCellValue(data);
		FileOutputStream fout= new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fout);
		
	}
	
	
	/**
	 * This method is used to readMultiple data from excel
	 * @param sheetName
	 * @return map
	 * @throws Throwable
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleData(String sheetName) throws Throwable, IOException
	{
		FileInputStream fi =new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fi);
		Sheet sh =wb.getSheet(sheetName);
		int count =sh.getLastRowNum();
		HashMap<String, String> map =new HashMap<String, String>();
		for(int i=0; i<=count ;i++)
		{
			String key =sh.getRow(i).getCell(0).getStringCellValue();
			String value =sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;	
	}
	
	public static Workbook workBook() throws Throwable
	{
		FileInputStream fi =new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb =WorkbookFactory.create(fi);
		return wb;
	
	}
	
	public void closeWorkbook(Workbook w) throws Throwable
	{
		w.close();
	}
	
	public Object[][] readMultipleSet(String sheetname) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRow = sh.getLastRowNum()+1;
		int  lastCell = sh.getRow(0).getLastCellNum();
		
		Object Obj[][] =new Object[lastRow][lastCell];
		
		for(int i=0; i<lastRow; i++)
		{
			for(int j=0; j<lastCell; j++)
			{
				Obj[i][j] =sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return Obj;
	}
	
	
	
	
	
	
	
}
