package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Porder;


public class PorderExcelWriter {


    public void writePorderListToExcel(List<Porder> porderList, String filePath) throws IOException {
        

        HSSFWorkbook workbook = new HSSFWorkbook();
        

        HSSFSheet sheet = workbook.createSheet("訂單資料");
        

        String[] headers = { "ID", "姓名", "鬆餅", "沙拉", "三明治", "單筆總金額" };
        HSSFRow headerRow = sheet.createRow(0); 
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }
        
       
        int rowNum = 1; 
        int wafflePrice = 119; 
        int saladPrice = 109;
        int sandwichPrice = 129;

        for (Porder p : porderList) {
            HSSFRow row = sheet.createRow(rowNum++);
            
            row.createCell(0).setCellValue(p.getId());
            row.createCell(1).setCellValue(p.getName());
            row.createCell(2).setCellValue(p.getWaffle());
            row.createCell(3).setCellValue(p.getSalad());
            row.createCell(4).setCellValue(p.getSandwich());

            int sum = p.getWaffle() * wafflePrice + p.getSalad() * saladPrice + p.getSandwich() * sandwichPrice;
            row.createCell(5).setCellValue(sum);
        }
        

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            workbook.write(out);
        }
        
        workbook.close();
    }
}