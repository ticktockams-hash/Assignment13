package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Porder;

/**
 * 專門用來將 Porder 列表匯出成 .xls Excel 檔案的工具類。
 * 這個版本採用一次性寫入，效能更佳。
 */
public class PorderExcelWriter {

    /**
     * 將一個 Porder 物件列表完整寫入一個新的 Excel 檔案中。
     * @param porderList 要寫入的訂單資料列表
     * @param filePath 儲存檔案的完整路徑 (例如 "C:/reports/Porder.xls")
     * @throws IOException 當檔案寫入失敗時拋出
     */
    public void writePorderListToExcel(List<Porder> porderList, String filePath) throws IOException {
        
        // 使用 HSSFWorkbook 來處理 .xls 格式
        HSSFWorkbook workbook = new HSSFWorkbook();
        
        // 建立一個名為「訂單資料」的工作表
        HSSFSheet sheet = workbook.createSheet("訂單資料");
        
        // --- 建立標頭列 ---
        // 注意：這裡的欄位名稱和價格，我採用 FindAllPorder.java 的「鬆餅/沙拉/三明治」版本，
        // 如果你需要改成「肚皮舞課程」或「LCD/RAM」，請修改這裡的文字和下方的價格。
        String[] headers = { "ID", "姓名", "鬆餅", "沙拉", "三明治", "單筆總金額" };
        HSSFRow headerRow = sheet.createRow(0); // 建立第一列
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }
        
        // --- 寫入資料內容 ---
        int rowNum = 1; // 資料從第二列開始 (索引為 1)
        int wafflePrice = 119; // 根據你的 FindAllPorder.java
        int saladPrice = 109;
        int sandwichPrice = 129;

        for (Porder p : porderList) {
            HSSFRow row = sheet.createRow(rowNum++);
            
            row.createCell(0).setCellValue(p.getId());
            row.createCell(1).setCellValue(p.getName());
            row.createCell(2).setCellValue(p.getWaffle());
            row.createCell(3).setCellValue(p.getSalad());
            row.createCell(4).setCellValue(p.getSandwich());
            
            // 計算單筆總金額
            int sum = p.getWaffle() * wafflePrice + p.getSalad() * saladPrice + p.getSandwich() * sandwichPrice;
            row.createCell(5).setCellValue(sum);
        }
        
        // --- 將 workbook 寫入檔案 ---
        // 使用 try-with-resources 確保 FileOutputStream 會被自動關閉
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            workbook.write(out);
        }
        
        // 最後關閉 workbook 釋放記憶體
        workbook.close();
    }
}