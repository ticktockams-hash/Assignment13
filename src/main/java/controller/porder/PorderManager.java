package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;
import controller.Login;
import model.Member;
import util.Tool;
import java.awt.Font; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class PorderManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManager frame = new PorderManager();
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
	public PorderManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel timeLabel = new JLabel("時間載入中...");
		timeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
		timeLabel.setBounds(244, 223, 180, 28); 
		contentPane.add(timeLabel);


		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeLabel.setText(Tool.getCurrentTime());
			}
		});
		timer.start();
		
		
		JLabel showMember = new JLabel("");
		showMember.setBounds(10, 10, 151, 28);
		contentPane.add(showMember);
		
		Member m=(Member)Tool.readFile("member.txt");
		
		String show="管理員:"+m.getName();
		
		showMember.setText(show);
		
		
		
		//Button
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorder addporder=new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(173, 48, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				FindAllPorder allporder=new FindAllPorder();
				allporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(173, 95, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				RevisePorder revisePorder=new RevisePorder();
				revisePorder.setVisible(true);
				dispose();	
				
				
			}
		});
		btnNewButton_2.setBounds(173, 148, 87, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DeletePorder deletePorder=new DeletePorder();
				deletePorder.setVisible(true);
				dispose();	
			}
		});
		btnNewButton_3.setBounds(173, 195, 87, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("返回");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();	
				
			}
		});
		btnNewButton_4.setBounds(295, 195, 87, 23);
		contentPane.add(btnNewButton_4);
		


	}

}
