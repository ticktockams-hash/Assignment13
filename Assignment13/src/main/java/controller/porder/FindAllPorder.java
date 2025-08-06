package controller.porder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Porder;
import service.impl.PorderServiceImpl;
import util.PorderExcelWriter; 

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
		allPorder.setBounds(38, 49, 532, 264);
		contentPane.add(allPorder);
		
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
		
		
		JButton btnExport = new JButton("匯出 Excel (.xls)");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				handleExportAction();
			}
		});
		btnExport.setBounds(342, 423, 150, 23);
		contentPane.add(btnExport);
	}

	/**
	 * 處理匯出按鈕的事件
	 */
	private void handleExportAction() {
		if (porderData == null || porderData.isEmpty()) {
			JOptionPane.showMessageDialog(this, "沒有資料可匯出！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("請選擇儲存位置");
		fileChooser.setSelectedFile(new java.io.File("訂單報表.xls"));
		fileChooser.setFileFilter(new FileNameExtensionFilter("Excel 檔案", "xls")); 

		int userSelection = fileChooser.showSaveDialog(this);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			java.io.File fileToSave = fileChooser.getSelectedFile();
			String filePath = fileToSave.getAbsolutePath();

			if (!filePath.toLowerCase().endsWith(".xls")) {
				filePath += ".xls";
			}

			try {
				
				PorderExcelWriter writer = new PorderExcelWriter();
				
				writer.writePorderListToExcel(porderData, filePath);
				
				JOptionPane.showMessageDialog(this, "Excel 檔案已成功匯出至：\n" 
				+ filePath, "匯出成功", JOptionPane.INFORMATION_MESSAGE);

			} catch (IOException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "匯出失敗，發生錯誤：\n" 
				+ ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}