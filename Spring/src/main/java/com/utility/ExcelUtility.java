package com.utility;

import java.io.File;
import com.entity.*;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelUtility 
{

	public boolean genreateExcel(HttpServletResponse response,List<EntityClass> all,File file) throws Exception
	{
		Workbook workbook =new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Citizen-name");
		row.createCell(2).setCellValue("Plan-name");
		row.createCell(3).setCellValue("plan-status");
		row.createCell(4).setCellValue("Plan-start-date");
		row.createCell(5).setCellValue("plan-end-date");
		row.createCell(6).setCellValue("Bineficary-amount");
		
	   
	    
	    int rowIndex=1;
	    
	    for(EntityClass entity:all) {
	    	Row row2 = sheet.createRow(rowIndex);
	    	
	    	row.createCell(0).setCellValue(entity.getCitizenId());
	    	row.createCell(1).setCellValue(entity.getCitizenName());
	    	row.createCell(2).setCellValue(entity.getPlanName());
	    	row.createCell(3).setCellValue(entity.getPlanStatus());
	    	
	    	if(null != entity.getPlanStartDate()) {
				row2.createCell(4).setCellValue(entity.getPlanStartDate()+"");	
			}
			else {
				row2.createCell(4).setCellValue("N/A");
			}
			if(null != entity.getPlanEndDate()) {
				row2.createCell(5).setCellValue(entity.getPlanEndDate()+"");
			}
			else {
				row2.createCell(5).setCellValue("N/A");
			}
			if(null != entity.getBenefitAmt()) {
				row2.createCell(6).setCellValue(entity.getBenefitAmt());
			}
			else {
				row2.createCell(6).setCellValue("N/A");
			}
			
			rowIndex++;
			
	    }
	    
	    FileOutputStream fileOutputStream=new FileOutputStream(file);
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		
	    ServletOutputStream outputStream = response.getOutputStream();
	    workbook.write(outputStream);
	    workbook.close();
	    
		return true;
	}
}
