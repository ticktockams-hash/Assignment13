package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Confirm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm frame = new Confirm();
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
	public Confirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel showMember = new JLabel("");
		showMember.setBounds(25, 10, 177, 47);
		contentPane.add(showMember);
		
		JTextPane showPorder = new JTextPane();
		showPorder.setBounds(25, 49, 335, 162);
		contentPane.add(showPorder);
		
		
		
		Porder p=(Porder)Tool.readFile("porder.txt");
		Member m=(Member)Tool.readFile("member.txt");
		
		showMember.setText("會員:"+m.getName());
		
		String show="你的購物細目:"+
		"\nLcd:"+p.getLcd()+
		"\nRam:"+p.getRam()+
		"\nMouse:"+p.getMouse()+
		"\n共:"+(p.getLcd()*4999+p.getRam()*799+p.getMouse()*200)+"元";
		
		showPorder.setText(show);
		
		
		/*button*/
		
		JButton btnNewButton = new JButton("回上一頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddPorder addporder=new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(70, 228, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("確認");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				 *1-addPorder()-->資料庫
				 *2->切換到->finish 
				 */
				
				new PorderServiceImpl().addPorder(p);
				Finish finish=new Finish();
				finish.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_1.setBounds(229, 228, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("確認");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});


	}
}
