package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField address;
	private JTextField phone;
	private JLabel errorMessage;
	private JTextField password;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(55, 10, 79, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setBounds(55, 51, 79, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setBounds(55, 92, 79, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setBounds(55, 133, 79, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("電話");
		lblNewLabel_4.setBounds(55, 174, 79, 31);
		contentPane.add(lblNewLabel_4);
		
		name = new JTextField();
		name.setBounds(103, 15, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(103, 56, 96, 21);
		contentPane.add(username);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(103, 138, 96, 21);
		contentPane.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(103, 179, 96, 21);
		contentPane.add(phone);
		
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
					errorMessage.setText("帳號重複");
				}				
				
				
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(258, 178, 87, 23);
		contentPane.add(btnNewButton);
		
		errorMessage = new JLabel("");
		errorMessage.setBounds(55, 223, 133, 28);
		contentPane.add(errorMessage);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(103, 97, 96, 21);
		contentPane.add(password);

	}

}
