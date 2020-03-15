package com.telesko;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.TenantDto;

@RestController
public class ReadTenant {
@RequestMapping("getTenant")
public List<TenantDto> getTenantFromFile() throws IOException{
	List<TenantDto> tenatdtolist = new ArrayList<>();
	 final String FILE_NAME = "F://testFile/dat.xlsx";
	 FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	 System.out.println("file set");
	
	 XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
	 XSSFSheet worksheet = workbook.getSheetAt(0);
	
	 System.out.println("file read");
	 for(int i=1;i<worksheet.getPhysicalNumberOfRows();i++)
	 	{
		 	TenantDto tennt=new TenantDto();
			XSSFRow row =worksheet.getRow(i);
			
			tennt.setName(row.getCell(0).getStringCellValue());
			tennt.setAdress(row.getCell(1).getStringCellValue());
			tennt.setAge((int) row.getCell(2).getNumericCellValue());
			tennt.setRoom_no((int) row.getCell(3).getNumericCellValue());
			tennt.setRent((double) row.getCell(4).getNumericCellValue());
			System.out.println("NAMe :"+tennt.getName());
			tenatdtolist.add(tennt);
	 	}
// write excel file mkfrom java
	 
 //Map<String,TenantDto> mTnt = new  HashMap<String, TenantDto>();	 
	 
	 final String FILE_NAME1 = "F://testFile/data12.xlsx";
		FileOutputStream opf=new FileOutputStream(new File(FILE_NAME1));
		XSSFWorkbook wrkBK= new XSSFWorkbook();
		//XSSFSheet wrkSheet=wrkBK.createSheet();
		XSSFSheet wrkSheet=worksheet;
		
		
   List<TenantDto> listTnt=new ArrayList<>();
   TenantDto tennt=new TenantDto();
   tennt.setName("D");
   tennt.setAge(22);
   tennt.setRent(5000);
   tennt.setAdress("pune");
   tennt.setRoom_no(105);
  
   TenantDto tennt1=new TenantDto();
   tennt1.setName("s");
   tennt1.setAge(45);
   tennt1.setRent(5000);
   tennt1.setAdress("nashik");
   tennt1.setRoom_no(105);
   
   listTnt.add(tennt);
   listTnt.add(tennt1);

   int rowNum =wrkSheet.getLastRowNum();
   rowNum++;
 		for (TenantDto toj :listTnt) 
 		{
 			 
 		 Row rw =wrkSheet.createRow(rowNum++);
	     int cellNumber=0;
		rw.createCell(cellNumber++).setCellValue(toj.getName());
		rw.createCell(cellNumber++).setCellValue(toj.getAdress());
		rw.createCell(cellNumber++).setCellValue(toj.getAge());
		rw.createCell(cellNumber++).setCellValue(toj.getRoom_no());
		rw.createCell(cellNumber++).setCellValue(toj.getRent());
			
 		}
   // write filer
 		
 		wrkBK.write(opf);
 		System.out.println("Writing on Excel file Finished ...");

 		opf.close();
 		workbook.close();
 		excelFile.close();
   
	return tenatdtolist;
}

}
