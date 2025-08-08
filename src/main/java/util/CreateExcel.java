package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Member;
import model.Porder;

public class CreateExcel {
	static HSSFSheet sheet = null;
    HSSFWorkbook excelbook=new HSSFWorkbook();
    //新增excel檔
    public void create(String FileName,String sheetName,String[] titleName)
    {
    	try {
			FileOutputStream out = new FileOutputStream(FileName);
			
			 sheet = excelbook.createSheet(sheetName);
			 HSSFRow row = sheet.createRow((short) 0);
			 for(int i=0;i<titleName.length;i++)
	         {
	           	row.createCell((short) i).setCellValue(titleName[i]);
	          }
			 excelbook.write(out);
			 out.flush();
			 out.close(); 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //新增member.xls value
    
    public void insertMemberValue(Member member,String fileName,String sheetName)
    {
    	try {
			excelbook = new HSSFWorkbook(new FileInputStream(fileName));
			HSSFSheet sheet = excelbook.getSheet(sheetName);        //獲得指定的工作表
	        int count = sheet.getPhysicalNumberOfRows();  
	        
	        HSSFRow row = sheet.createRow((short) count); 
	        
	        row.createCell((short) 0).setCellValue(member.getId());        // 在索引0的位置建立單元格（左上端）
	        row.createCell((short) 1).setCellValue(member.getName());
	        row.createCell((short) 2).setCellValue(member.getUsername());
	        row.createCell((short) 3).setCellValue(member.getPassword());
	        row.createCell((short) 4).setCellValue(member.getAddress());
	        row.createCell((short) 5).setCellValue(member.getPhone());  
	        
	        
	        FileOutputStream out;// 新增輸出檔案流        
	        out = new FileOutputStream(fileName);
	        excelbook.write(out);// 把對應的Excel工作簿存碟
	        out.flush();
	        
	        
		} 
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    //新增porder.xls value
    
    public void insertPorderValue(Porder porder,String fileName,String sheetName)
    {
    	try {
			excelbook = new HSSFWorkbook(new FileInputStream(fileName));
			HSSFSheet sheet = excelbook.getSheet(sheetName);        //獲得指定的工作表
	        int count = sheet.getPhysicalNumberOfRows();  
	        
	        HSSFRow row = sheet.createRow((short) count); 
	        
	        row.createCell((short) 0).setCellValue(porder.getId());        // 在索引0的位置建立單元格（左上端）
	        row.createCell((short) 1).setCellValue(porder.getName());
	        row.createCell((short) 2).setCellValue(porder.getLcd());
	        row.createCell((short) 3).setCellValue(porder.getRam());
	        row.createCell((short) 4).setCellValue(porder.getMouse());
	        int sum=porder.getLcd()*4999+porder.getRam()*1280+porder.getMouse()*700;
	        row.createCell((short) 5).setCellValue(sum);  
	        
	        
	        FileOutputStream out;// 新增輸出檔案流        
	        out = new FileOutputStream(fileName);
	        excelbook.write(out);// 把對應的Excel工作簿存碟
	        out.flush();
	        
	        
		} 
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
