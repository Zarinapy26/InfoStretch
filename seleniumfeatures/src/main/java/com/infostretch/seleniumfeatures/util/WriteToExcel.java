package com.infostretch.seleniumfeatures.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class WriteToExcel 
{
   public static void writeToExcel(String FilePath,String SheetName,List<String> list) throws IOException
   {
	   File file=new File(FilePath);
	   FileInputStream fis=new FileInputStream(file);
	   int dot=FilePath.indexOf(".");
	   String FileExt=FilePath.substring(dot+1);
	   Workbook workbook=null;
	   if(FileExt.equals("xls"))
	   {
		   workbook=new HSSFWorkbook(fis);
	   }
	   else if(FileExt.equals("xlsx"))
	   {
		   workbook=new XSSFWorkbook(fis);
	   } 
	   Row row=workbook.getSheet(SheetName).createRow(workbook.getSheet(SheetName).getLastRowNum()+1);
	   for(int i=0;i<list.size();i++)
	   {
		   Cell cell=row.createCell(i);
		   cell.setCellValue(list.get(i));
	   }
	   
	   fis.close();
	   FileOutputStream fos=new FileOutputStream(file);
	   workbook.write(fos);
	   fos.close();
	   
   }
	 
}
