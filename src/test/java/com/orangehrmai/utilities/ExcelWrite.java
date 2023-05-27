package com.orangehrmai.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public  FileInputStream fis=null;
	public  FileOutputStream fos=null;
	public  XSSFWorkbook workbook=null;
	public  XSSFSheet sheet=null;
	public  XSSFRow row=null;
	public  XSSFCell cell=null;
	String xlFilePath;
	
	public ExcelWrite(String xlFilePath) throws Exception{
		this.xlFilePath=xlFilePath;
		fis=new FileInputStream(xlFilePath);
		workbook=new XSSFWorkbook(fis);
		fis.close();
	}
	
	public boolean setCellData(String sheetName,String colName,int rowNum, String Value) throws IOException
	{
		int colNum=0;
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
			{
				colNum=i;
			}
		}
	
		row=sheet.getRow(rowNum);
		if(row==null)
			row=sheet.createRow(rowNum);
		cell=row.getCell(colNum);
		if(cell==null)
			cell=row.createCell(colNum);
		cell.setCellValue(Value);
		
		fos=new FileOutputStream(xlFilePath);
		workbook.write(fos);
		fos.close();
		return true;
		
	}
	

}


