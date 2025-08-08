package controller.member;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import controller.LoginUser;
import model.MemberUser;
import service.impl.MemberUserServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMemberUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel errorMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUser frame = new AddMemberUser();
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
	public AddMemberUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 23, 57, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 71, 57, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(44, 106, 57, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(44, 147, 46, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("電話");
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(44, 182, 68, 18);
		contentPane.add(lblNewLabel_4);
		
		name = new JTextField();
		name.setBounds(122, 28, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(122, 68, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(122, 103, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(122, 144, 96, 21);
		contentPane.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(122, 179, 96, 21);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel timeLabel = new JLabel("時間載入中...");
		timeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		timeLabel.setBounds(229, 231, 180, 20); 
		contentPane.add(timeLabel);

		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				timeLabel.setText(Tool.getCurrentTime());
			}
		});
		timer.start(); 
		
		
		//Button
		
		btnNewButton = new JButton("確認");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name = name.getText();
		        String UserName = username.getText();
		        String Password = password.getText();
		        String Address = address.getText();
		        String Phone = phone.getText();
		        
		        errorMessage.setText("");
		        
		        MemberUser memberuser = new MemberUser(Name, UserName, Password, Address, Phone);
		        
		        if (new MemberUserServiceImpl().addMemberUser(memberuser)) 
		        {
		            JOptionPane.showMessageDialog(null, "註冊成功！");
		            LoginUser loginuser = new LoginUser();  
		            loginuser.setVisible(true);
		            dispose();
		        } 
		        else 
		        {
		            errorMessage.setText("帳號已存在");
		        }

			}
		});
		btnNewButton.setBounds(308, 139, 87, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUser loginuser=new LoginUser();
				loginuser.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(308, 178, 87, 23);
		contentPane.add(btnNewButton_1);
		
		errorMessage = new JLabel("");
		errorMessage.setBounds(256, 31, 128, 55);
		contentPane.add(errorMessage);
			
	}

}
