package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login;
import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setTitle("會員註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 10, 59, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(50, 59, 59, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(50, 109, 59, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(50, 164, 59, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("電話");
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(50, 209, 59, 35);
		contentPane.add(lblNewLabel_3_1);
		
		name = new JTextField();
		name.setBounds(119, 18, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(119, 67, 96, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(119, 117, 96, 21);
		contentPane.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(119, 172, 96, 21);
		contentPane.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(119, 217, 96, 21);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel errorMessage = new JLabel("");
		errorMessage.setFont(new Font("新細明體", Font.PLAIN, 20));
		errorMessage.setForeground(new Color(255, 0, 0));
		errorMessage.setBounds(267, 39, 135, 69);
		contentPane.add(errorMessage);
		
		/*Button*/
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=name.getText();
				String UserName=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				
				Member member=new Member(Name,UserName,Password,Address,Phone);
				
				if(new MemberServiceImpl().addMember(member))
				{
					AddMemberSuccess addMembersuccess=new AddMemberSuccess();
					addMembersuccess.setVisible(true);
					dispose();
				}
				else
				{
					errorMessage.setText("帳號已存在");
				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton.setBounds(274, 141, 117, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		btnNewButton_1.setBounds(273, 209, 117, 35);
		contentPane.add(btnNewButton_1);
		


	}

}
