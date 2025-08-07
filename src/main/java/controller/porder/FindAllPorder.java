package controller.porder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

// 匯入新的 POI 套件 for .xlsx
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Porder;
import service.impl.PorderServiceImpl;

public class FindAllPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PorderServiceImpl psi = new PorderServiceImpl();
	private List<Porder> porderData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindAllPorder frame = new FindAllPorder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FindAllPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		

		JTextArea allPorder = new JTextArea();
		allPorder.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(allPorder);
		scrollPane.setBounds(38, 49, 532, 264);
		contentPane.add(scrollPane);
		
		JLabel sum = new JLabel("計算中...");
		sum.setBounds(38, 323, 532, 66);
		contentPane.add(sum);
		
		this.porderData = psi.findAllPorder();
		
		StringBuilder showBuilder = new StringBuilder();
		int count = 0;
		int WAFFLE = 0;
		int SALAD = 0;
		int SANDWICH = 0;
		
		for (Porder p : this.porderData) {
			showBuilder.append("ID:" + p.getId())
					   .append("\t姓名:" + p.getName())
					   .append("\t鬆餅:" + p.getWaffle())
					   .append("\t沙拉:" + p.getSalad())
					   .append("\t三明治:" + p.getSandwich())
					   .append("\n");
			count++;
			WAFFLE += p.getWaffle();
			SALAD += p.getSalad();
			SANDWICH += p.getSandwich();
		}
		
		allPorder.setText(showBuilder.toString());
		int allSum = WAFFLE * 119 + SALAD * 109 + SANDWICH * 129;
		sum.setText("筆數:" + count + "    鬆餅:" + WAFFLE + "  沙拉:" 
		+ SALAD + "  三明治:" + SANDWICH + "   銷售總金額:" + allSum + "元");
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 PorderManager porderManager = new PorderManager();
				 porderManager.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(85, 423, 87, 23);
		contentPane.add(btnNewButton);
		
		
		// 修改按鈕文字與事件
		JButton btnExport = new JButton("匯出Excel");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 直接呼叫新的 exportToExcel 方法
				exportToExcel(porderData);
			}
		});
		btnExport.setBounds(342, 423, 150, 23);
		contentPane.add(btnExport);
	}

	/**
	 * 新的匯出 Excel 方法，風格與 PorderReadUI 相同
	 */
	private void exportToExcel(List<Porder> data) {
		if (data == null || data.isEmpty()) {
			JOptionPane.showMessageDialog(this, "沒有資料可匯出！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		String[] headers = { "ID", "姓名", "鬆餅", "沙拉", "三明治", "單筆總金額" };
		String filePath = "訂單報表.xlsx";
		
		// 使用 XSSFWorkbook 來處理 .xlsx 格式
		Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("訂單資料");

	    // 建立標題列
	    Row headerRow = sheet.createRow(0);
	    CellStyle headerStyle = workbook.createCellStyle();
	    XSSFFont headerFont = (XSSFFont) workbook.createFont();
	    headerFont.setBold(true);
	    headerStyle.setFont(headerFont);

	    for (int col = 0; col < headers.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(headers[col]);
	        cell.setCellStyle(headerStyle);
	    }

	    // 寫入資料
	    int rowNum = 1;
	    for (Porder p : data) {
	        Row excelRow = sheet.createRow(rowNum++);
	        excelRow.createCell(0).setCellValue(p.getId());
	        excelRow.createCell(1).setCellValue(p.getName());
	        excelRow.createCell(2).setCellValue(p.getWaffle());
	        excelRow.createCell(3).setCellValue(p.getSalad());
	        excelRow.createCell(4).setCellValue(p.getSandwich());
	        // 計算單筆總金額
	        int singleSum = p.getWaffle() * 119 + p.getSalad() * 109 + p.getSandwich() * 129;
	        excelRow.createCell(5).setCellValue(singleSum);
	    }

	    // 自動調整欄寬
	    for (int col = 0; col < headers.length; col++) {
	        sheet.autoSizeColumn(col);
	    }

	    // 儲存檔案
	    try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
	        workbook.write(fos);
	        JOptionPane.showMessageDialog(this, "建立 " + filePath + " 成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
	    } catch (IOException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Excel 匯出失敗！", "錯誤", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}
}