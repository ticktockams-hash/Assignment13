package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import model.Member;
import model.Porder;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField waffle;
	private JTextField salad;
	private JTextField sandwich;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorder frame = new AddPorder();
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
	public AddPorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("鬆餅套餐(119)");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 63, 119, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("沙拉套餐(109)");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 112, 119, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("總匯套餐(129)");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(37, 157, 119, 39);
		contentPane.add(lblNewLabel_1_1);
		
		waffle = new JTextField();
		waffle.setBounds(166, 73, 96, 21);
		contentPane.add(waffle);
		waffle.setColumns(10);
		
		salad = new JTextField();
		salad.setBounds(166, 122, 96, 21);
		contentPane.add(salad);
		salad.setColumns(10);
		
		sandwich = new JTextField();
		sandwich.setBounds(166, 167, 96, 21);
		contentPane.add(sandwich);
		sandwich.setColumns(10);
		
		
		JLabel showMember = new JLabel("");
		showMember.setBounds(37, 10, 131, 43);
		contentPane.add(showMember);

		Member m=(Member)Tool.readFile("member.txt");
		
		String show="管理員:"+m.getName();
		
		showMember.setText(show);
		
		
		//Button
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Waffle=Integer.parseInt(waffle.getText());
				int Salad=Integer.parseInt(salad.getText());
				int Sandwich=Integer.parseInt(sandwich.getText());
				
				Porder p=new Porder(m.getName(),Waffle,Salad,Sandwich);
				Tool.saveFile(p, "porder.txt");
 				
				Confirm confirm=new Confirm();
				confirm.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(285, 89, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				waffle.setText("");
				salad.setText("");
				sandwich.setText("");
			}
		});
		btnNewButton_1.setBounds(285, 128, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(285, 166, 87, 23);
		contentPane.add(btnNewButton_2);
		

	}

}
