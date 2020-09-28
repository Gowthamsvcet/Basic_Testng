package excelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {
	
	public  Object[][] excel() throws Exception {
		File nfile = new File ("E:\\Eclipse JS Project\\CRMFA\\Resourse\\Data.xlsx");
		FileInputStream NF = new FileInputStream (nfile);
		XSSFWorkbook wook = new XSSFWorkbook (NF);
		XSSFSheet sheet = wook.getSheetAt(0);
		int row_count = sheet.getLastRowNum();
		System.out.println("Row Count : " +row_count);
		int col_count = sheet.getRow(0).getLastCellNum();
		System.out.println("Cell Count : " +col_count);
		Object [][] obj  = new Object [row_count] [col_count];
		for(int i=1; i<=row_count;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<col_count;j++)
			{
				XSSFCell cell = row.getCell(j);
				String Cellvalue = cell.getStringCellValue();
				obj[i-1][j]=Cellvalue;
				System.out.println(Cellvalue);
			}
		}
		return obj;
	
	}

}
