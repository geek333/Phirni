package com.testing.util;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


@SuppressWarnings("unused")
public class ExcelHandler {
	
	private Workbook wb;
	private FileInputStream fis;
	private Sheet dataSheet;
	
	public boolean setWorkBook(String workbookName,String folderName)
	{
		boolean flag=true;
		
		try
		{
			fis=new FileInputStream(System.getProperty("user.dir")+"\\"+folderName+"\\"+workbookName+".xlsx");
			wb=new HSSFWorkbook(fis);
		}catch(Exception e)
		{
			flag=false;
			System.out.println("Error while interacting with workbook : "+workbookName);
		}
		
		return flag;
	}// set workbook  ends here 
	
	
	public boolean setSheet(String sheetName)
	{
		boolean flag=true;
		
		
		try {
			
			dataSheet=wb.getSheet(sheetName);
		}catch(Exception e) {
			
			flag=false;
			System.out.println("Error interacting with sheet : "+sheetName);
		}
		
		return flag;
	}// set sheet  ends here 
	
	
	public boolean setSheet(int sheetNumber)
	{
		boolean flag=true;
		
			
			try {
			
			dataSheet=wb.getSheetAt(sheetNumber);
			}catch(Exception e)
				{
			
			flag=false;
			System.out.println("Error interacting with sheet : "+sheetNumber);
		}
		
		return flag;
	}
	// set workbook  ends here 
	
	@SuppressWarnings("deprecation")
	public String getDatafromCell(int row,int column)
	{
		String data=null;
		int rowCount=0;
		
		if(dataSheet!=null)
		{
			
			Iterator<Row> rowIterator=dataSheet.iterator();
			
			
			while(rowIterator.hasNext())
			{
				
				Row currRow=rowIterator.next();
				if(rowCount==row)
				{
					int columnCount=0;
					Iterator<Cell> cellIterator=currRow.cellIterator();
					
					while(cellIterator.hasNext())
					{
						if(columnCount==column)
						{
							Cell currentCell = cellIterator.next();
							
		                   if( currentCell.getCellTypeEnum()==CellType.STRING)
		                   {
		                	   data=currentCell.getStringCellValue();
		                   }
		                   if( currentCell.getCellTypeEnum()==CellType.NUMERIC)
		                   {
		                	   data=Double.toString(currentCell.getNumericCellValue());
		                    
		                   }
						
						
					}// if ends here
				}//Cell count comparison ends here
				
				rowCount++;
			}// row iterator ends here 
		}// row iterator ends here
	}
		
		return data;
			
		}// get cell data ends here
	}//class ends here
