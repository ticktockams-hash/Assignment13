package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lcd;
	private JTextField ram;
	private JTextField mouse;
	private JButton btnNewButton;

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
		
		JLabel lblNewLabel = new JLabel("LCD");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel.setBounds(71, 87, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblRam = new JLabel("RAM");
		lblRam.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblRam.setBounds(71, 126, 46, 15);
		contentPane.add(lblRam);
		
		JLabel lblMouse = new JLabel("MOUSE");
		lblMouse.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblMouse.setBounds(59, 168, 74, 15);
		contentPane.add(lblMouse);
		
		lcd = new JTextField();
		lcd.setBounds(143, 84, 96, 21);
		contentPane.add(lcd);
		lcd.setColumns(10);
		
		ram = new JTextField();
		ram.setColumns(10);
		ram.setBounds(143, 123, 96, 21);
		contentPane.add(ram);
		
		mouse = new JTextField();
		mouse.setColumns(10);
		mouse.setBounds(143, 165, 96, 21);
		contentPane.add(mouse);
		
		JLabel showMember = new JLabel("");
		showMember.setBounds(30, 20, 87, 46);
		contentPane.add(showMember);
		
		
		Member m=(Member)Tool.readFile("member.txt");
		
		String show="會員:"+m.getName();
		
		showMember.setText(show);
		
		btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取->lcd,ram,mouse-->轉型-->int
				 * 2.new Porder();
				 * 3.Tool-->porder.txt
				 * 4.切換到-->Confirm
				 */
				int Lcd=Integer.parseInt(lcd.getText());
				int Ram=Integer.parseInt(ram.getText());
				int Mouse=Integer.parseInt(mouse.getText());
				
				Porder p=new Porder(m.getName(),Lcd,Ram,Mouse);
				Tool.saveFile(p, "porder.txt");
				
				Confirm confirm=new Confirm();
				confirm.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(152, 208, 87, 23);
		contentPane.add(btnNewButton);

	}
}
