package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.Tool;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class Finish extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finish frame = new Finish();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Finish() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		Member member=(Member)Tool.readFile("member.txt");
		Porder porder=(Porder)Tool.readFile("porder.txt");
		
		JTextPane showReporter = new JTextPane();
		showReporter.setBounds(49, 61, 484, 236);
		contentPane.add(showReporter);
		
	    int sum = porder.getWaffle() * 119 + 
	              porder.getSalad() * 109 + 
	              porder.getSandwich() * 129;
		
		
	    String show = "客戶名稱:" + member.getName() + "\t\t地址:" + member.getAddress() + "\t\t連絡電話:" + member.getPhone() +
	            "\n=======================================================" +
	            "\n鬆餅套餐(119):" + porder.getWaffle() + "份" +
	            "\n沙拉套餐(109):" + porder.getSalad() + "份" +
	            "\n總匯套餐(129):" + porder.getSandwich() + "份" +				
	            "\n========================================================" +
	            "\n小計:" + sum + "元";
		
		
		showReporter.setText(show);
		
		JLabel showMessage = new JLabel("");
		showMessage.setBounds(49, 10, 371, 36);
		contentPane.add(showMessage);
		
		showMessage.setText("訂單已完成 ,"+member.getName()+"\t這是你的細目");
		
		
		
		//Button
		
		JButton btnNewButton = new JButton("回首頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(115, 361, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("列印");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					showReporter.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(344, 361, 87, 23);
		contentPane.add(btnNewButton_1);

	}

}
