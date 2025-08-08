package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderManager;
import model.Member;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel showMessage = new JLabel("");
		showMessage.setBounds(89, 30, 268, 43);
		showMessage.setFont(new Font("新細明體", Font.BOLD, 16));
		contentPane.add(showMessage);
		
		Member member=(Member)Tool.readFile("member.txt");
		String show=member.getName()+",歡迎你";
		
		showMessage.setText(show);
		
		
		/**button**/
		
		
		JButton btnNewButton = new JButton("進入購物");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManager pm=new PorderManager();
				pm.setVisible(true);
				dispose();
				
			}
		
		});
		btnNewButton.setBounds(160, 131, 87, 23);
		contentPane.add(btnNewButton);

	}

}