package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMemberUser;
import controller.member.LoginError;
import controller.member.LoginSuccess;
import controller.porder.PorderUserManager;
import model.Member;
import model.MemberUser;
import service.impl.MemberServiceImpl;
import service.impl.MemberUserServiceImpl;
import util.Tool;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Font;

public class LoginUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUser frame = new LoginUser();
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
	public LoginUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		

		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel.setBounds(67, 80, 61, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(67, 144, 61, 18);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(138, 79, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(138, 143, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("會員登入");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(142, 20, 116, 38);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel timeLabel = new JLabel("時間載入中...");
		timeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		timeLabel.setBounds(67, 231, 180, 20); 
		contentPane.add(timeLabel);

		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				timeLabel.setText(Tool.getCurrentTime());
			}
		});
		timer.start(); 
		
		//Button
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username=username.getText();
				String Password=password.getText();
				
				MemberUser m=new MemberUserServiceImpl().login(Username, Password);
			   
			    if (m != null) {
			       
			        JOptionPane.showMessageDialog(null, "登入成功！歡迎 " + m.getName());
			        util.Tool.saveFile(m, "memberuser.txt");
			        dispose();

			        PorderUserManager porderusermanager = new PorderUserManager();
			        porderusermanager.setVisible(true);
			        
			    } else {

		
			        JOptionPane.showMessageDialog(null, "登入失敗，帳號或密碼錯誤！");
			        password.setText("");
			
			    }
			}
		});
		btnNewButton.setBounds(269, 94, 87, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("切換使用者");
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();	
				
			}
		});
		btnNewButton_1.setBounds(285, 29, 124, 23);
		contentPane.add(btnNewButton_1);
		

		
		JButton btnNewButton_2 = new JButton("註冊");
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 15));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUser addmemberuser=new AddMemberUser();
				addmemberuser.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(269, 178, 87, 23);
		contentPane.add(btnNewButton_2);

	}
}
