package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Porder;
import service.impl.PorderServiceImpl;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RevisePorder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField waffle;
	private JTextField salad;
	private JTextField sandwich;
	private PorderServiceImpl psi = new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RevisePorder frame = new RevisePorder();
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
	public RevisePorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel.setBounds(49, 31, 42, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblWaffle = new JLabel("鬆餅套餐");
		lblWaffle.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblWaffle.setBounds(49, 80, 69, 39);
		contentPane.add(lblWaffle);
		
		JLabel lblSalad = new JLabel("沙拉套餐");
		lblSalad.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblSalad.setBounds(49, 129, 69, 39);
		contentPane.add(lblSalad);
		
		JLabel lblSandwich = new JLabel("總匯套餐");
		lblSandwich.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblSandwich.setBounds(49, 184, 69, 39);
		contentPane.add(lblSandwich);
		
		id = new JTextField();
		id.setBounds(139, 40, 96, 21);
		contentPane.add(id);
		id.setColumns(10);
		
		waffle = new JTextField();
		waffle.setBounds(139, 89, 96, 21);
		contentPane.add(waffle);
		waffle.setColumns(10);
		
		salad = new JTextField();
		salad.setBounds(139, 138, 96, 21);
		contentPane.add(salad);
		salad.setColumns(10);
		
		sandwich = new JTextField();
		sandwich.setBounds(139, 193, 96, 21);
		contentPane.add(sandwich);
		sandwich.setColumns(10);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ID=Integer.parseInt(id.getText());
				int Waffle=Integer.parseInt(waffle.getText());
				int Salad=Integer.parseInt(salad.getText());
				int Sandwich=Integer.parseInt(sandwich.getText());
				Porder p=new Porder();
				p.setId(ID);
				p.setWaffle(Waffle);
				p.setSalad(Salad);
				p.setSandwich(Sandwich);
				
				boolean isSuccess = psi.updatePoder(p);
				
		        if (isSuccess) {
		            JOptionPane.showMessageDialog(null, "訂單 ID: " + ID + " 修改成功！");
		        } else {
		            JOptionPane.showMessageDialog(null, "修改失敗，找不到訂單 ID: " + ID);
				//psi.updatePoder(p);
		        }
			}
		});
		btnNewButton.setBounds(311, 154, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderManager porderManager=new PorderManager();
				porderManager.setVisible(true);
				dispose();	
				
			}
		});
		btnNewButton_1.setBounds(311, 192, 87, 23);
		contentPane.add(btnNewButton_1);

	}

}
