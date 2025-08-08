package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Member member=(Member)Tool.readFile("member.txt");
		Porder porder=(Porder)Tool.readFile("porder.txt");
		
		
		JLabel showMessage = new JLabel("");
		showMessage.setBounds(28, 10, 156, 32);
		contentPane.add(showMessage);
		
		showMessage.setText("訂單已完成 ,"+member.getName()+"\t這是你的細目");
		
		
		JTextPane showReporter = new JTextPane();
		showReporter.setBounds(38, 51, 336, 154);
		contentPane.add(showReporter);
		
		int sum=porder.getLcd()*4999+porder.getRam()*799+porder.getMouse()*200;
		String show="客戶名稱:"+member.getName()+"\t地址:"+member.getAddress()+"\t\t連絡電話:"+member.getPhone()+
				"\n======================================================="+
				"\nLCD:"+porder.getLcd()+"台"+
				"\nRAM:"+porder.getRam()+"套"+
				"\nMOUSE:"+porder.getMouse()+"個"+				
				"\n========================================================"+
				"\n小計:"+sum+"元";
		
		
		showReporter.setText(show);
		
		
		/**button**/
		
		
		JButton btnNewButton = new JButton("回首頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(71, 215, 87, 23);
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
		btnNewButton_1.setBounds(249, 215, 87, 23);
		contentPane.add(btnNewButton_1);
		
		
	
		
		

		
	}
}
