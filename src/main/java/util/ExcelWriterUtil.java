package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Porder;


public class ExcelWriterUtil {


    public static void writePordersToExcel(String filePath, String sheetName, List<Porder> porders) {
        
  
        try (HSSFWorkbook workbook = new HSSFWorkbook();
             FileOutputStream out = new FileOutputStream(filePath)) {
            

            HSSFSheet sheet = workbook.createSheet(sheetName);
            

            String[] headers = { "ID", "名字", "LCD螢幕", "記憶體", "滑鼠", "總金額" };
            HSSFRow headerRow = sheet.createRow(0); // 第 0 列是標頭
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }
            
            int rowNum = 1; 
            for (Porder p : porders) {
                HSSFRow row = sheet.createRow(rowNum++);
                
                row.createCell(0).setCellValue(p.getId());
                row.createCell(1).setCellValue(p.getName());
                row.createCell(2).setCellValue(p.getWaffle());
                row.createCell(3).setCellValue(p.getSalad());
                row.createCell(4).setCellValue(p.getSandwich());
                

                int sum = p.getWaffle() * 119 + p.getSalad() * 109 + p.getSandwich() * 129;
                row.createCell(5).setCellValue(sum);
            }
            

            workbook.write(out);
            
            System.out.println("Excel 檔案已成功建立於: " + filePath);

        } catch (IOException e) {
            System.err.println("寫入 Excel 檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
    }
}