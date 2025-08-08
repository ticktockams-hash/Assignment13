package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

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
		setLocationRelativeTo(null);
		
		JLabel showMember = new JLabel("");
		showMember.setBounds(57, 10, 121, 23);
		contentPane.add(showMember);
		
		JTextPane showPoder = new JTextPane();
		showPoder.setBounds(57, 44, 319, 152);
		contentPane.add(showPoder);
		
		Porder p=(Porder)Tool.readFile("porder.txt");
		Member m=(Member)Tool.readFile("member.txt");
		
		showMember.setText("會員:"+m.getName());
		
		String show = "您的購物細目:" +
	    "\n鬆餅套餐:" + p.getWaffle() + "份" +
	    "\n沙拉套餐:" + p.getSalad() + "份" +
	    "\n總匯套餐:" + p.getSandwich() + "份" +
	    "\n\n共:" + (p.getWaffle() * 119 + p.getSalad() * 109 + p.getSandwich() * 129) + "元";

		showPoder.setText(show);
		
		//Button
		
		JButton btnNewButton = new JButton("回上一頁");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorder addporder=new AddPorder();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(73, 217, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("確認");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new PorderServiceImpl().addPorder(p);
				Finish finish=new Finish();
				finish.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(260, 217, 87, 23);
		contentPane.add(btnNewButton_1);
		


	}
}
