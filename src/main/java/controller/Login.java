package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMember;
import controller.member.LoginError;
import controller.member.LoginSuccess;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBounds(185, 62, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(185, 109, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel.setBounds(104, 61, 62, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(104, 103, 62, 31);
		contentPane.add(lblNewLabel_1);
		
		
		
		/***按鈕**/
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				Member m=new MemberServiceImpl().login(Username, Password);
				
				if(m!=null)
				{
					Tool.saveFile(m,"member.txt");
					
					LoginSuccess loginSuccess=new LoginSuccess();
					loginSuccess.setVisible(true);
					dispose();
				}
				else
				{
					LoginError loginError=new LoginError();
					loginError.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(87, 172, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMember addmember=new AddMember();
				addmember.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(216, 172, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(273, 230, 151, 21);
		contentPane.add(lblNewLabel_2);

	}
}
