package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddMember;
import controller.member.LoginError;
import controller.member.LoginSuccess;
import controller.porder.PorderManager;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;
import javax.swing.Timer; 
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel timeLabel = new JLabel("時間載入中...");
		timeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		timeLabel.setBounds(244, 231, 180, 20); 
		contentPane.add(timeLabel);

		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				timeLabel.setText(Tool.getCurrentTime());
			}
		});
		timer.start(); 
		
		JLabel lblNewLabel = new JLabel("管理登入");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 25));
		lblNewLabel.setBounds(145, 20, 129, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(67, 74, 85, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(67, 113, 60, 38);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(155, 83, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(154, 122, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		
		
		/*Button*/
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(284, 82, 85, 60);
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
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		btnNewButton_1.setBounds(124, 179, 70, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("清除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 15));
		btnNewButton_2.setBounds(204, 179, 70, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("切換使用者");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUser loginUser=new LoginUser();
				loginUser.setVisible(true);
				dispose();	
				
			}
		});
		btnNewButton_3.setBounds(294, 20, 118, 23);
		contentPane.add(btnNewButton_3);

	}
}
