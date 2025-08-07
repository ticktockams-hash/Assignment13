package controller.porder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUser;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.Timer;

import model.Member;
import model.MemberUser;
import model.Porder;
import model.PorderUser;
import util.Tool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class FinishUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinishUser frame = new FinishUser();
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
	public FinishUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		MemberUser memberuser=(MemberUser)Tool.readFile("memberuser.txt");
		PorderUser porderuser=(PorderUser)Tool.readFile("porderuser.txt");
		
		JTextPane showReporter = new JTextPane();
		showReporter.setBounds(31, 40, 350, 176);
		contentPane.add(showReporter);
		
		int sum = porderuser.getWaffle() * 119 + 
	              porderuser.getSalad() * 109 + 
	              porderuser.getSandwich() * 129;
		
		String show = "客戶名稱:" + memberuser.getName() + "\t\t地址:" + memberuser.getAddress() + 
	    		"\t\t\t\t連絡電話:" + memberuser.getPhone() +
	            "\n=======================================================" +
	            "\n鬆餅套餐(119):" + porderuser.getWaffle() + "份" +
	            "\n沙拉套餐(109):" + porderuser.getSalad() + "份" +
	            "\n總匯套餐(129):" + porderuser.getSandwich() + "份" +				
	            "\n========================================================" +
	            "\n小計:" + sum + "元";
		
		showReporter.setText(show);
		
		JLabel timeLabel = new JLabel("時間載入中...");
		timeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		timeLabel.setBounds(37, 10, 180, 20); 
		contentPane.add(timeLabel);

		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				timeLabel.setText(Tool.getCurrentTime());
			}
		});
		timer.start(); 
		
		
		
		//Button
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderUserManager porderUsermanager = new PorderUserManager();
				porderUsermanager.setVisible(true);
                dispose();
            
			}
		});
		btnNewButton.setBounds(64, 228, 87, 23);
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
		btnNewButton_1.setBounds(252, 228, 87, 23);
		contentPane.add(btnNewButton_1);
		


	}
}
